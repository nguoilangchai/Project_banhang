const btn = document.querySelectorAll("#add-to-cart");
//console.log(btn);

//alert("hello 2");
function TaoDoiTuongSP(hinhAnh, ten, gia, id, soLuong) {
    var sanPham = new Object();
    //Bước 1: gắn các thuộc tính cho đối tượng
    sanPham.hinhAnh = hinhAnh;
    sanPham.ten = ten;
    sanPham.gia = gia;
    sanPham.idSanPham = id;
    sanPham.soLuong = soLuong;

    return sanPham;
}

//var danhSachSanPham = JSON.parse(localStorage.getItem('danhSachSanPham'));
//if (danhSachSanPham == null)
//    danhSachSanPham = new Array();
//  console.log(danhSachSanPham);

btn.forEach(function (button, index) {
    button.addEventListener("click", function (event) {
        
        var btnItem = event.target;
        var product = btnItem.parentElement;

        // 1. Truy cập các node để lấy dữ liệu
        var productImg = product.querySelector("img").src;
        var productName = product.querySelector("h4>a>h4").innerText;

        var productPrice = product.querySelector("span").innerText;
        var productId = product.querySelector("h1").innerText;
//        alert('Sản phẩm có id là : ' + productId);
        var userId = product.querySelector("h2").innerText;
        // Bước 4: Nếu sản phẩm đã tồn tại trong giỏ hàng thì thông báo sản phẩm đã có trong giỏ hàng
        
        var userIDGioHang = 'userID'+userId;
//        var userIDGioHang = '13';   
        var danhSachSanPham = JSON.parse(localStorage.getItem(userIDGioHang));
        if (danhSachSanPham === null)
            danhSachSanPham = new Array();
        
        
        var coTonTaiTrongDanhSachItemGioHang = false;

        for (var i = 0; i < danhSachSanPham.length; i++) {

            // Nếu tồn tại thì tăng số lượng
            if (danhSachSanPham[i].idSanPham === productId) {
                danhSachSanPham[i].soLuong++;
                coTonTaiTrongDanhSachItemGioHang = true;
            }
        }


        // Bước 5: Nếu không tồn tại, tạo ra đối tượng và thêm vào danh sách item giỏ hàng
        if (coTonTaiTrongDanhSachItemGioHang === false) {
            var itemGioHang = TaoDoiTuongSP(productImg, productName, productPrice, productId, 1);
            danhSachSanPham.push(itemGioHang);
        }


//
//        //3. Đưa sản phẩm vào danh sách
//        danhSachSanPham.push(sanPham);
//        console.log(danhSachSanPham);

        //chuyển mảng đối tượng thành mảng JSON
        var tempJson = JSON.stringify(danhSachSanPham);
//        console.log(tempJson);

        // 4. Lưu trữ danh sách sản phẩm xuống local storage
//        var x = 'userID' + 
        localStorage.setItem(userIDGioHang, tempJson);
        alert('Thêm sản phẩm thành công!');
//        danhSachItemGioHang.push(sanPham);
//        console.log(danhSachItemGioHang);
    });
});


