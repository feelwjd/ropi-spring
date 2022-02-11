function form_check(){
	var checkArray = new Array();
    	
	$("input[name='inputCheck[]']:checked").each(function(){
		var tmpVal = $(this).val();
		checkArray.push(tmpVal);
	});
	
	console.log('check: ' + checkArray);
	
	if(checkArray.length < 1 ){
    	alert("값을 선택해주시기 바랍니다.");
    	return;
    }else{
    	$("#selectedDB").val(checkArray);
    	alert($("#selectedDB").val());
    }
	
	var symbol = document.getElementById("symbol");
	var countrycode = document.getElementById("countrycode");
	var sectorcode = document.getElementById("sectorcode");
	var industrycode = document.getElementById("industrycode");
	var tradunit = document.getElementById("tradunit");
	var nationcode = document.getElementById("nationcode");
	var reg = /^[0-9]+/g;
	var symbolCheck = /^(?=.{1,16}$)[a-zA-Z0-9]*[^$%^&*;:,<>?()\"']*$/;
	var countrycodeCheck = /^(?=.{0,1}$)[a-zA-Z0-9]*[^$%^&*;:,<>?()\"']*$/;
	var sectorcodeCheck = /^(?=.{0,4}$)[a-zA-Z0-9]*[^$%^&*;:,<>?()\"']*$/;
	var industrycodeCheck = /^(?=.{0,4}$)[a-zA-Z0-9]*[^$%^&*;:,<>?()\"']*$/;
	var nationcodeCheck = /^(?=.{0,2}$)[a-zA-Z0-9]*[^$%^&*;:,<>?()\"']*$/;
	if(symbol.value ==""){
	    alert("SYMBOL 값을 입력하세요.");
	    symbol.focus();
	    return false;
	};
	
	if(!symbolCheck.test(symbol.value)){
	    alert("16자리까지 입력 가능합니다.");
	    symbol.focus();
	    return false;
	};
	
	if(countrycode.value ==""){
	    alert("COUNTRYCODE 값을 입력하세요.");
	    countrycode.focus();
	    return false;
	};
	
	if(!countrycodeCheck.test(countrycode.value)){
	    alert("1자리까지 입력 가능합니다.");
	    countrycode.focus();
	    return false;
	};
	
	if(!sectorcodeCheck.test(sectorcode.value)){
	    alert("4자리까지 입력 가능합니다.");
	    sectorcode.focus();
	    return false;
	};
	
	if(!industrycodeCheck.test(industrycode.value)){
	    alert("4자리까지 입력 가능합니다.");
	    industrycode.focus();
	    return false;
	};
	
	
	if(!nationcodeCheck.test(nationcode.value)){
	    alert("2자리까지 입력 가능합니다.");
	    nationcode.focus();
	    return false;
	};
	
	if(!reg.test(tradunit.value)){
	    alert("숫자만 입력하세요.");
	    tradunit.focus();
	    return false;
	};
	
	document.saveSummary.submit();
}

$(document).ready(function(){
});

$('.sectorList').click(function(){
	$("#sectorcode").val($(this).data("value"));
	$("#sectorName").val($(this).text());
});

$('.industryList').click(function(){
	$("#industrycode").val($(this).data("value"));
	$("#industryName").val($(this).text());
});

