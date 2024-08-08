<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MatBang Form</title>
</head>
<body>
<h1>MatBang Form</h1>
<form action="matbang" method="post">
    <input type="hidden" name="id" value="${matBang.id}">
    <label for="maMb">Ma MB:</label>
    <input type="text" name="maMb" value="${matBang.maMb}" required><br>
    <label for="dienTich">Dien Tich:</label>
    <input type="number" name="dienTich" value="${matBang.dienTich}" required><br>
    <label for="trangThai">Trang Thai:</label>
    <input type="text" name="trangThai" value="${matBang.trangThai}" required><br>
    <label for="tang">Tang:</label>
    <input type="number" name="tang" value="${matBang.tang}" required><br>
    <label for="loaiVp">Loai VP:</label>
    <input type="text" name="loaiVp" value="${matBang.loaiVp}" required><br>
    <label for="moTa">Mo Ta:</label>
    <textarea name="moTa" required>${matBang.moTa}</textarea><br>
    <label for="gia">Gia:</label>
    <input type="number" name="gia" value="${matBang.gia}" required><br>
    <label for="ngayBatDau">Ngay Bat Dau:</label>
    <input type="date" name="ngayBatDau" value="${matBang.ngayBatDau}" required><br>
    <label for="ngayKetThuc">Ngay Ket Thuc:</label>
    <input type="date" name="ngayKetThuc" value="${matBang.ngayKetThuc}" required><br>
    <button type="submit" name="action" value="${matBang.id == 0 ? 'save' : 'update'}">Save</button>
</form>
</body>
</html>
