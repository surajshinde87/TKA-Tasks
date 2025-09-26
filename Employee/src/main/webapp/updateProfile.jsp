<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    if (session.getAttribute("empId") == null) {
        response.sendRedirect("login.html");
        return;
    }
    int empId = (Integer) session.getAttribute("empId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Profile</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #6a11cb, #2575fc);
        margin: 0;
        padding: 0;
    }
    .update-container {
        max-width: 800px;
        margin: 50px auto;
        background: #fff;
        border-radius: 15px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.2);
        overflow: hidden;
        padding: 30px;
    }
    h2 {
        text-align: center;
        color: #007bff;
        margin-bottom: 30px;
    }
    .form-group {
        margin-bottom: 15px;
    }
    label {
        display: block;
        font-weight: bold;
        color: #333;
        margin-bottom: 5px;
    }
    input[type=text], input[type=email], input[type=tel], input[type=date], input[type=number], select {
        width: 100%;
        padding: 10px;
        border-radius: 6px;
        border: 1px solid #ccc;
        font-size: 15px;
    }
    input[type=file] {
        margin-top: 5px;
    }
    button {
        display: block;
        width: 100%;
        padding: 12px;
        font-size: 16px;
        font-weight: bold;
        color: white;
        background-color: #28a745;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        margin-top: 20px;
        transition: 0.3s;
    }
    button:hover {
        background-color: #218838;
    }
    .profile-image {
        display: block;
        width: 150px;
        height: 150px;
        margin: 0 auto 20px auto;
        border-radius: 50%;
        object-fit: cover;
        border: 4px solid #007bff;
    }
</style>
</head>
<body>

<div class="update-container">
    <h2>Update Your Profile</h2>

    <img class="profile-image" src="<%= session.getAttribute("profileImage") != null ? "displayImage?empId=" + empId : "https://cdn.pixabay.com/photo/2016/08/08/09/17/avatar-1577909_1280.png" %>" alt="Profile Image">

    <form action="updateProfile" method="post" enctype="multipart/form-data">
        <input type="hidden" name="empId" value="<%= empId %>">

        <div class="form-group">
            <label for="fullName">Full Name</label>
            <input type="text" id="fullName" name="fullName" value="<%= session.getAttribute("fullName") %>" required>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" value="<%= session.getAttribute("email") %>" required>
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="tel" id="phone" name="phone" value="<%= session.getAttribute("phone") %>" required>
        </div>

        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" id="address" name="address" value="<%= session.getAttribute("address") %>" required>
        </div>

        <div class="form-group">
            <label for="department">Department</label>
            <input type="text" id="department" name="department" value="<%= session.getAttribute("department") %>" required>
        </div>

        <div class="form-group">
            <label for="designation">Designation</label>
            <input type="text" id="designation" name="designation" value="<%= session.getAttribute("designation") %>" required>
        </div>

        <div class="form-group">
            <label for="profileImage">Profile Image</label>
            <input type="file" id="profileImage" name="profileImage">
        </div>

        <button type="submit">Update Profile</button>
    </form>
</div>

</body>
</html>
