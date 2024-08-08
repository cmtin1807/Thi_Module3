CREATE DATABASE TCComplex;
USE TCComplex;

CREATE TABLE mat_bang
(
    id_mb         INT PRIMARY KEY AUTO_INCREMENT,
    ma_mb         VARCHAR(10) CHECK (ma_mb REGEXP '^[A-Z0-9]{3}-[A-Z0-9]{2}-[A-Z0-9]{2}$'),
    dien_tich     INT         NOT NULL check ( dien_tich > 20 ),
    trang_thai    VARCHAR(50) NOT NULL,
    tang          INT         NOT NULL check (tang <= 15),
    loai_vp       VARCHAR(20) NOT NULL check ( loai_vp = 'Cho thuê' or loai_vp = 'Trọn gói' ),
    mo_ta         TEXT        NOT NULL,
    gia           INT         NOT NULL check (gia > 1000000),
    ngay_bat_dau  DATE        NOT NULL,
    ngay_ket_thuc DATE        NOT NULL

);
INSERT INTO mat_bang (ma_mb, dien_tich, trang_thai, tang, loai_vp, mo_ta, gia, ngay_bat_dau, ngay_ket_thuc)
VALUES ('MB0-01-02', 100, 'Trống', 2, 'Cho thuê', 'Mặt bằng 1', 2000000, '2020-11-20', '2021-11-25'),
       ('MB0-01-02', 240, 'Trống', 5, 'Trọn gói', 'Mặt bằng 2', 5000000, '2020-04-03', '2020-10-03'),
       ('MB0-01-02', 150, 'Hạ tầng', 3, 'Cho thuê', 'Mặt bằng 3', 3000000, '2021-01-01', '2022-01-01'),
       ('MB0-01-02', 120, 'Đầy đủ', 1, 'Cho thuê', 'Mặt bằng 4', 4000000, '2020-05-05', '2021-05-05'),
       ('MB0-01-02', 200, 'Trống', 4, 'Trọn gói', 'Mặt bằng 5', 2500000, '2020-06-06', '2021-06-06'),
       ('MB0-01-02', 180, 'Hạ tầng', 2, 'Cho thuê', 'Mặt bằng 6', 2700000, '2021-02-02', '2022-02-02'),
       ('MB0-01-02', 130, 'Đầy đủ', 5, 'Trọn gói', 'Mặt bằng 7', 3100000, '2020-03-03', '2021-03-03'),
       ('MB0-01-55', 170, 'Trống', 3, 'Cho thuê', 'Mặt bằng 8', 2900000, '2020-07-07', '2021-07-07'),
       ('MB0-01-44', 220, 'Hạ tầng', 4, 'Trọn gói', 'Mặt bằng 9', 3200000, '2021-04-04', '2022-04-04'),
       ('MB0-01-03', 140, 'Đầy đủ', 1, 'Cho thuê', 'Mặt bằng 10', 2100000, '2020-08-08', '2021-08-08');

SELECT * FROM mat_bang