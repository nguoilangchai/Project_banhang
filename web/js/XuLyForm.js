function checkName(){
    var name = document.getElementById("user-name").value.trim();
    
    var regexName = /^[^\d+]*[\d+]{0}[^\d+]*$/;
    if(name == null || name == ''){
        alert("Họ tên không được để trống !");
        document.getElementById("user-name").value = '';
    }
    else if(!regexName.test(name)){
        alert("Tên không được chứa số");
        document.getElementById("user-name").value = '';
    }
}

function checkSDT(){
    var sdt = document.getElementById("sdt").value.trim();
    
    var regexSDT = /^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/;
    if(sdt == null || sdt == ''){
        alert("Số điện thoại không được để trống !");
        document.getElementById("sdt").value = '';
    }
    else if(!regexSDT.test(sdt)){
        alert("Số điện thoại không hợp lệ !")
        document.getElementById("sdt").value = '';
    }
   
}


