
var userID = document.getElementById('duyNhat').innerText;
var userIDGioHang = 'userID'+userID;

hienThiDanhSachItemGioHang();
//var userID = document.getElementById('duyNhat').innerText;


//var userIDGioHang = 'userID'+userID;

//const x = 16;

function layDanhSachItemGioHang() {
    var danhSachItemGioHang = new Array();

    // Bước 1: Lấy chuỗi json lưu trữ trong local storage
    var jsonDanhSachItemGioHang = localStorage.getItem(userIDGioHang);
//    console.log(jsonDanhSachItemGioHang);

    // Bước 2: Chuyển từ json qua danh sách item giỏ hàng  
    if (jsonDanhSachItemGioHang != null)
        danhSachItemGioHang = JSON.parse(jsonDanhSachItemGioHang);
    return danhSachItemGioHang;
}

function hienThiDanhSachItemGioHang() {
    //Bước1 : Lấy danh sách item giỏ hàng dưới local storage lên
    var danhSachItemGioHang = layDanhSachItemGioHang();
//    console.log(danhSachItemGioHang);

    // Bước 2: chuyển danh sách item giỏ hàng thành HTML
    var HTML = chuyenDanhSachItemGioHangSangHTML(danhSachItemGioHang);
//    console.log(HTML);

    // Bước 3: truy cập node gio-hang để hiển thị HTML danh sách item giỏ hàng lên
    var nodeGioHang = document.getElementById('danhSachItemGioHang');
//    console.log(nodeGioHang);
    nodeGioHang.innerHTML = HTML;

}
// Mô tả: Chuyển một danh sách thành html
// input: danh sách item giỏ hàng
// output: html hiển thị danh sách item giỏ hàng
function chuyenDanhSachItemGioHangSangHTML(danhSachItemGioHang) {
    var htmlTong = '';
    var tongTien = 0;
    for (var i = 0; i < danhSachItemGioHang.length; i++) {
        htmlTong += chuyenDoiTuongItemGioHangSangHTML(danhSachItemGioHang[i]);
        tongTien += danhSachItemGioHang[i].soLuong * danhSachItemGioHang[i].gia;
    }
    htmlTong += '<tr>\n' +
            '        <td></td>\n' +
            '        <td></td>\n' +
            '        <td></td>\n' +
            '        <td></td>\n' +
            '        <td><strong>Total</strong></td>\n' +
            '        <td class="text-right"><strong>' + tongTien + ' $</strong></td>\n' +
            '    </tr>';

    return htmlTong;
}
// Mô tả: Chuyển một đối tượng thành html
// input: đối tượng giỏ hàng
// output: HTML hiển thị item giỏ hàng
function chuyenDoiTuongItemGioHangSangHTML(itemGioHang) {
//    var tien = document.getElementById('tinhTien');
//    console.log(tien);
    //Bước 2: Khi có đối tượng, thay thế những giá trị của đối tượng vào đoạn HTML 

    var HTML = '<tr>\n' +
            '                                        <td><img src="' + itemGioHang.hinhAnh + '" /> </td>\n' +
            '                                        <td>' + itemGioHang.ten + '</td>\n' +
            '                                        <td>' + itemGioHang.gia + '$</td>\n' +
            '                                        <td><input class="form-control" type="number" name="" id="' + itemGioHang.idSanPham + '" value="' + itemGioHang.soLuong + '" min="1" onchange="TinhTien(' + itemGioHang.idSanPham + ')"></td>\n' +
            '                                        <td id ="ok" class="text-right">' + itemGioHang.gia * itemGioHang.soLuong + ' $</td>\n' +
            '                                        <td class="text-right"><button class="btn btn-sm btn-danger" onclick="XoaItem(' + itemGioHang.idSanPham + ')"><i class="fa fa-trash"></i> </button> </td>\n' +
            '                                    </tr>';

    return HTML;
}

function TinhTien(id) {
//    console.log('san pham co id : ' + id);
    var danhSachItemGioHang = layDanhSachItemGioHang();
    var soLuongMua = document.getElementById(id).value;
//    console.log(soLuongMua);
    for (var i = 0; i < danhSachItemGioHang.length; i++) {
        // Nếu tồn tại thì thay đổi số lượng 
        if (danhSachItemGioHang[i].idSanPham == id) {
            console.log('có tồn tại 2');
            danhSachItemGioHang[i].soLuong = soLuongMua;
            console.log('sau khi thay đổi : ' + danhSachItemGioHang[i].soLuong);
        }
    }
    var tempJson = JSON.stringify(danhSachItemGioHang);
//        console.log(tempJson);

    // 4. Lưu trữ danh sách sản phẩm xuống local storage
    localStorage.setItem(userIDGioHang, tempJson);
    hienThiDanhSachItemGioHang();
}

function XoaItem(id) {
    var danhSachItemGioHang = layDanhSachItemGioHang();
    var soLuongMua = document.getElementById(id).value;
//    console.log(soLuongMua);
    for (var i = 0; i < danhSachItemGioHang.length; i++) {
        // Nếu tồn tại thì thay đổi số lượng 
        if (danhSachItemGioHang[i].idSanPham == id) {
            console.log('có tồn tại 2');
            danhSachItemGioHang.splice(i, 1); 
//            console.log('sau khi thay đổi : ' + danhSachItemGioHang[i].soLuong);
        }
    }
    var tempJson = JSON.stringify(danhSachItemGioHang);
//        console.log(tempJson);

    // 4. Lưu trữ danh sách sản phẩm xuống local storage
    localStorage.setItem(userIDGioHang, tempJson);
    hienThiDanhSachItemGioHang();
}

//console.log("Xoá item thành công");


