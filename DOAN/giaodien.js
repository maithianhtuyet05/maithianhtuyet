/*
document.getElementById("register-form").addEventListener("submit", function(event){
    event.preventDefault();
    
    // Lấy giá trị từ các trường nhập liệu
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    
    // Kiểm tra yêu cầu tên đăng nhập
    var usernameRegex = /^[a-zA-Z0-9_]+$/; // Chỉ cho phép các kí tự chữ, số và dấu gạch dưới (_)
    if (!usernameRegex.test(username)) {
      document.getElementById("error-message").textContent = "Tên đăng nhập không hợp lệ. Vui lòng nhập lại.";
      return;
    }
    
    // Kiểm tra yêu cầu mật khẩu
    var passwordRegex = /^(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$/; // Tối thiểu 8 kí tự và phải chứa ít nhất 1 kí tự đặc biệt
    if (!passwordRegex.test(password)) {
      document.getElementById("error-message").textContent = "Mật khẩu không hợp lệ. Vui lòng nhập lại.";
      return;
    }
    
    // Logic xử lý đăng ký tài khoản tại đây (có thể gửi dữ liệu đăng ký đến server, lưu vào cơ sở dữ liệu, v.v.)
    console.log("Đăng ký thành công!");

  });
  */
  document.getElementById("login-form").addEventListener("submit", function(event){
    event.preventDefault();
    
    // Lấy giá trị từ các trường nhập liệu
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    
    // Kiểm tra tài khoản admin
    var adminUsername = "admin";
    var adminPassword = "admin@123";
    
    if (username === adminUsername && password === adminPassword) {
      // Đăng nhập thành công, chuyển hướng sang trang admin
      window.location.href = "index.html"; // Thay "trang_admin.html" bằng đường dẫn đến trang admin thực tế
    } else {
      // Sai tên đăng nhập hoặc mật khẩu, hiển thị thông báo lỗi
      document.getElementById("error-message").textContent = "Tên đăng nhập hoặc mật khẩu không chính xác.";
    }
  });