function goDetail(symbol, countrycode) {
	window.location.href = "../detail/" + symbol + "/" + countrycode;
}

function changeFile(){
    	submitFile = document.getElementById('fileInput');
	    submitBtn = document.getElementById('fileSubmit');

	    if(submitFile.value.length > 0){
	    	submitBtn.disabled = false;
	    }else{
	    	submitBtn.disabled = true;
	    }
    }

    function resetFile(){
    	submitFile = document.getElementById('fileInput');
	    submitBtn = document.getElementById('fileSubmit');

	    submitBtn.disabled = true;
    }