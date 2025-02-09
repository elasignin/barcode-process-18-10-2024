package com.ingramcontent.consolidated.labels.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ingramcontent.consolidated.labels.model.BarcodeActionSignal;
import com.ingramcontent.consolidated.labels.model.CopyLabel;
import com.ingramcontent.consolidated.labels.model.Item;
import com.ingramcontent.consolidated.labels.model.ToteInformation;

/**
 * This class was automatically generated by the data modeler tool.
 */
public class ToteInformationHelper implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    
    private final static int READY = 1; 
    private final static int INPROCESS = 2;
    private final static int PRINTED = 3; 
    private final static int COMPLETED = 4;
    private final static int ABANDON = 10;
    private final static int WAITING = 6; 
    private final static int SKIP = 8; 
    private final static int REMOVE = 9; 

    public ToteInformationHelper() {
    }
     
    public static void barcodeActionRule(BarcodeActionSignal barcodeAction) {
    	ToteInformation signal = barcodeAction.getToteInformation();
    	if(signal == null ||
    	   signal.getItems() == null || 
    	   signal.getItems().size() == 0) {
    		return;
    	}
    	
    	switch (signal.getStatus()) {
			case INPROCESS:
				  processInProcess(signal);
				break;
			case ABANDON:
				  processAbandon(signal);
				break;
			case COMPLETED:
				  processCompleted(signal);
				break;	
		}
    	
    }
    
    private static void processInProcess(ToteInformation signal) {
         for(Item item: signal.getItems()) {    		
	    	 
	    	 if(item.getCopyLabels() == null || 
	    		item.getCopyLabels().size() == 0) {
	    		continue;
	    	 }
	    	
	    	 boolean ready = false;	
	    	 for(CopyLabel labelSignal: item.getCopyLabels()) {
    			switch (labelSignal.getStatus()) {
					case SKIP:
						break;					
					case READY:
						labelSignal.setStatus(INPROCESS);
						ready = true;
						break;
				}
	    	 }
	    	 
	    	 if(ready) {
	    		 item.setStatusID(INPROCESS); 
	    		 continue;
	    	 }
	    	 
	    	 List<Integer> status = item.getCopyLabels().stream()
		    			                .map(CopyLabel::getStatus)
		    			                .collect(Collectors.toList());
		    			                
	    	 boolean waiting = status.stream().anyMatch(val -> val == WAITING);
	    	 if(waiting) {
	    		 item.setStatusID(WAITING); 
	    		 continue;
	    	 }
	    	 
	    	 boolean remove = status.stream().allMatch(val -> val == REMOVE);
	    	 if(remove) {
	    		 item.setStatusID(REMOVE); 
	    		 continue;
	    	 }
	    	 
	    	 boolean skip = status.stream().allMatch(val -> val == SKIP);
	    	 if(skip) {
	    		 item.setStatusID(SKIP); 
	    		 continue;
	    	 }
	    	 
	    	 boolean printed = status.stream().allMatch(val -> val == PRINTED || val == REMOVE || val == SKIP);
	    	 if(printed) {
	    		 item.setStatusID(PRINTED); 
	    		 continue;
	    	 }
	    	 
	    	 
    	}
    }
    
    private static void processAbandon(ToteInformation signal) {
    	  List<Integer> itemStatus = new ArrayList<>();
	      for(Item item: signal.getItems()) {	   		
		    	 if(item.getCopyLabels() == null || 
		    		item.getCopyLabels().size() == 0) {
		    		continue;
		    	 }
		    	 
		    	 List<Integer> status = item.getCopyLabels().stream()
		    			                .map(CopyLabel::getStatus)
		    			                .collect(Collectors.toList());
		    	 
		    	 boolean waiting = status.stream().anyMatch(val -> val == WAITING);
		    	 if(waiting) {
		    		 item.setStatusID(WAITING);
		    		 itemStatus.add(WAITING);
		    		 continue;
		    	 }
		    	 
		    	 boolean ready = status.stream().anyMatch(val -> val != WAITING && val == READY);
		    	 if(ready) {
		    		 item.setStatusID(READY);
		    		 itemStatus.add(READY);
		    		 continue;
		    	 }
		    	 
		    	 boolean printed = status.stream().allMatch(val -> val == PRINTED || val == SKIP || val == REMOVE);
		    	 if(printed) {
		    		 item.setStatusID(PRINTED);
		    		 itemStatus.add(PRINTED);
		    		 continue;
		    	 }
		    	 
		    	 if(item.getStatusID() != null) {
		    	    itemStatus.add(item.getStatusID());
		         }
	   	}
	    
         boolean waiting = itemStatus.stream().anyMatch(val -> val == WAITING);
    	 if(waiting) {
    		 signal.setStatus(WAITING);
    		 return;
    	 }
    	 
    	 boolean ready = itemStatus.stream().anyMatch(val -> val != WAITING && val == READY);
    	 if(ready) {
    		 signal.setStatus(READY);
    		 return;
    	 }
    	 
    	 boolean printed = itemStatus.stream().allMatch(val -> val == PRINTED || val == SKIP);
    	 if(printed) {
    		 signal.setStatus(PRINTED);
    		 return;
    	 }  
   }
    
    private static void processCompleted(ToteInformation signal) {
  	      List<Integer> itemStatus = new ArrayList<>();
	      for(Item item: signal.getItems()) {	   		
	    	 if(item.getCopyLabels() == null || 
	    		item.getCopyLabels().size() == 0) {
	    		continue;
	    	 }
	    	 
	    	 if(item.getStatusID() != null) {
	    	   itemStatus.add(item.getStatusID());
	    	 }
	    	 
	    	 List<Integer> status = item.getCopyLabels().stream()
	    			                .map(CopyLabel::getStatus)
	    			                .collect(Collectors.toList());
	    	 
	    	 boolean printed = status.stream().anyMatch(val -> val == PRINTED);
	    	 if(printed) {
	    		 item.setStatusID(PRINTED);
	    		 itemStatus.add(PRINTED);
	    		 continue;
	    	 }
	    	 
	    	 boolean completed = status.stream().allMatch(val -> val == COMPLETED || val == SKIP || val == REMOVE);
	    	 if(completed) {
	    		 item.setStatusID(COMPLETED);
	    		 itemStatus.add(COMPLETED);
	    		 continue;
	    	 }
	    	 
	    	 if(item.getStatusID() != null) {
		    	 itemStatus.add(item.getStatusID());
		     }
	   	}
	    
         boolean printed = itemStatus.stream().anyMatch(val -> val == PRINTED);
	  	 if(printed) {
	  		 signal.setStatus(PRINTED);
	  		 return;
	  	 }
	  	 
	  	 boolean completed = itemStatus.stream().allMatch(val -> val == COMPLETED);
	  	 if(completed) {
	  		 signal.setStatus(COMPLETED);
	  		 return;
	  	 }  
	 } 
       
}