function a(){
	console.log('a');
}

function form_check(){
        var checkServer = "";
        $( "input[name='server']:checked" ).each (function (){
            checkServer = checkServer + $(this).val()+",";
        });
        checkServer = checkServer.substring(0,checkServer.lastIndexOf( ",")); //맨끝 콤마 지우기
        console.log(checkServer);
        if (checkServer == ""){
            alert("서버를 선택해주세요.")
            return false;
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

        var url = "";
        var addr = url + checkServer;

        alert(addr);
        $("#form").attr("action",addr );
        document.saveSummary.submit();
    }