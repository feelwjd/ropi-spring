function deleteSummary(){
    	if(confirm("삭제하시겠습니까?")){
    		var database = $("#database").val();
    		$("#summaryForm").attr("action", "/" + database + "/deleteSummary");
    		$("#summaryForm").submit();
    	}
    }
    
    function updateSummary(){
		var database = $("#database").val();
    	$("#summaryForm").attr("action", "/" + database + "/updateSummary");
    	$("#summaryForm").submit(); 
    }
    
    function copySummary(){
    	var checkArray = new Array();
    	
    	$("input[name='inputCheck[]']:checked").each(function(){
    		var tmpVal = $(this).val();
    		checkArray.push(tmpVal);
    	});
    	
    	if(checkArray.length < 1 ){
   	    	alert("값을 선택해주시기 바랍니다.");
   	    	return;
   	    }else{
   	    	$("#selectedDB").val(checkArray);
   	    	$("#copyForm").submit();
   	    }
    }