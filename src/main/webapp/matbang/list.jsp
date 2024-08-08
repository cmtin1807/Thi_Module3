<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MatBang List</title>
</head>
<body>
<h1>MatBang List</h1>
<a href="matbang?action=new">Add New MatBang</a>
<form action="matbang" method="get">
    <input type="hidden" name="action" value="search">
    <label for="loaiVp">Search by Loai VP:</label>
    <input type="text" id="loaiVp" name="loaiVp">
    <input type="submit" value="Search">
</form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Ma MB</th>
        <th>Dien Tich</th>
        <th>Trang Thai</th>
        <th>Tang</th>
        <th>Loai VP</th>
        <th>Mo Ta</th>
        <th>Gia</th>
        <th>Ngay Bat Dau</th>
        <th>Ngay Ket Thuc</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="matBang" items="${listMatBang}">
        <tr>
            <td>${matBang.id}</td>
            <td>${matBang.maMb}</td>
            <td>${matBang.dienTich}</td>
            <td>${matBang.trangThai}</td>
            <td>${matBang.tang}</td>
            <td>${matBang.loaiVp}</td>
            <td>${matBang.moTa}</td>
            <td>${matBang.gia}</td>
            <td>${matBang.ngayBatDau}</td>
            <td>${matBang.ngayKetThuc}</td>
            <td>
                <a href="matbang?action=edit&id=${matBang.id}">Edit</a>
                <a href="matbang?action=delete&id=${matBang.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
