// Import SweetAlert2
import Swal from 'sweetalert2';

// Bắt sự kiện khi trang đã tải xong
document.addEventListener('DOMContentLoaded', function () {
    const trashButtons = document.querySelectorAll('.trash');
    trashButtons.forEach((trashButton) => {
        trashButton.addEventListener('click', (event) => {
            event.preventDefault();
            // Sử dụng SweetAlert2
            Swal.fire({
                title: "Cảnh báo",
                text: "Bạn có chắc chắn là muốn xóa nhân viên này?",
                icon: "warning",
                showCancelButton: true,
                confirmButtonColor: "#3085d6",
                cancelButtonColor: "#d33",
                confirmButtonText: "Đồng ý",
                cancelButtonText: "Hủy bỏ",
            }).then((result) => {
                if (result.isConfirmed) {
                    // Thực hiện xóa ở đây sau khi xác nhận
                    // Điều hướng hoặc gửi yêu cầu xóa đến server ở đây
                    Swal.fire("Đã xóa thành công!", "", "success");
                }
            });
        });
    });
});
