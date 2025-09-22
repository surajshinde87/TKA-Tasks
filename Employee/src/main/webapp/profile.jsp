<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Profile</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #6a11cb, #2575fc);
        margin: 0;
        padding: 0;
    }
    .profile-container {
        max-width: 900px;
        margin: 50px auto;
        background: #fff;
        border-radius: 15px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.2);
        overflow: hidden;
        display: flex;
        flex-wrap: wrap;
        padding: 30px;
        transition: transform 0.3s;
    }
    .profile-container:hover {
        transform: translateY(-5px);
    }
    .profile-image-section {
        flex: 1;
        min-width: 250px;
        text-align: center;
        padding: 20px;
        border-right: 1px solid #eee;
    }
    .profile-image-section img {
        width: 160px;
        height: 160px;
        border-radius: 50%;
        object-fit: cover;
        border: 4px solid #007bff;
        transition: transform 0.3s;
    }
    .profile-image-section img:hover {
        transform: scale(1.1);
    }
    .profile-details-section {
        flex: 2;
        min-width: 300px;
        padding: 20px 40px;
    }
    .profile-details-section h2 {
        margin-top: 0;
        color: #007bff;
    }
    .profile-details-section h3 {
        margin-bottom: 10px;
        color: #333;
        border-bottom: 2px solid #007bff;
        display: inline-block;
        padding-bottom: 3px;
    }
    .profile-details-section p {
        margin: 8px 0;
        font-size: 15px;
        color: #555;
    }
    .label {
        font-weight: bold;
        color: #333;
    }
    .buttons {
        margin-top: 20px;
    }
    .btn {
        display: inline-block;
        padding: 10px 20px;
        margin-right: 15px;
        border-radius: 6px;
        text-decoration: none;
        color: white;
        font-weight: bold;
        transition: 0.3s;
    }
    .btn-update {
        background-color: #28a745;
    }
    .btn-update:hover {
        background-color: #218838;
    }
    .btn-logout {
        background-color: #dc3545;
    }
    .btn-logout:hover {
        background-color: #c82333;
    }

    @media (max-width: 768px) {
        .profile-container {
            flex-direction: column;
            padding: 20px;
        }
        .profile-image-section {
            border-right: none;
            border-bottom: 1px solid #eee;
            margin-bottom: 20px;
        }
        .profile-details-section {
            padding: 10px 0;
        }
    }
</style>
</head>
<body>

<div class="profile-container">
    <div class="profile-image-section">
       <img alt="profile-image" src="displayImage?empId=${sessionScope.empId}">

        <h3 style="margin-top:10px;">${sessionScope.fullName}</h3>
        <p>${sessionScope.designation} - ${sessionScope.department}</p>
    </div>

    <div class="profile-details-section">
        <h2>Employee Profile</h2>

        <h3>Personal Information</h3>
        <p><span class="label">Employee ID:</span> ${sessionScope.empId}</p>
        <p><span class="label">Date of Birth:</span> ${sessionScope.dob}</p>
        <p><span class="label">Gender:</span> ${sessionScope.gender}</p>
        <p><span class="label">Email:</span> ${sessionScope.email}</p>
        <p><span class="label">Phone:</span> ${sessionScope.phone}</p>
        <p><span class="label">Address:</span> ${sessionScope.address}</p>

        <h3>Work Information</h3>
        <p><span class="label">Date of Joining:</span> ${sessionScope.doj}</p>
        <p><span class="label">Salary:</span> ₹${sessionScope.salary}</p>
        <p><span class="label">PAN:</span> ${sessionScope.pan}</p>
        <p><span class="label">Aadhaar:</span> ${sessionScope.aadhaar}</p>
        <p><span class="label">Bank Account:</span> ${sessionScope.bankAccount}</p>
        <p><span class="label">IFSC:</span> ${sessionScope.ifsc}</p>

        <div class="buttons">
            <a href="updateProfile.jsp" class="btn btn-update">Update Profile</a>
            <a href="index.html" class="btn btn-logout">Logout</a>
        </div>
    </div>
</div>

</body>
</html>
