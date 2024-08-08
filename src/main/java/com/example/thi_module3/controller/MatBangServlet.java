package com.example.thi_module3.controller;

import com.example.thi_module3.model.MatBang;
import com.example.thi_module3.repository.MatBangRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "MatBangServlet", urlPatterns = {"/matbang"})
public class MatBangServlet extends HttpServlet {
    private MatBangRepository matBangRepository;

    @Override
    public void init() throws ServletException {
        matBangRepository = new MatBangRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteMatBang(request, response);
                break;
            case "search":
                searchMatBang(request, response);
                break;
            case "searchByTang":
                searchMatBangByTang(request, response);
                break;
            case "list":
            default:
                listMatBang(request, response);
                break;
        }
    }
    private void searchMatBangByTang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tang = Integer.parseInt(request.getParameter("tang"));
        List<MatBang> listMatBang = matBangRepository.findByTang(tang);
        request.setAttribute("listMatBang", listMatBang);
        request.getRequestDispatcher("matbang-list.jsp").forward(request, response);
    }
    private void searchMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loaiVp = request.getParameter("loaiVp");
        List<MatBang> listMatBang = matBangRepository.findByLoaiVp(loaiVp);
        request.setAttribute("listMatBang", listMatBang);
        request.getRequestDispatcher("matbang-list.jsp").forward(request, response);
    }
    private void listMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MatBang> listMatBang = matBangRepository.findAll();
        request.setAttribute("listMatBang", listMatBang);
        request.getRequestDispatcher("matbang/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("matbang/form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MatBang existingMatBang = matBangRepository.findById(id);
        request.setAttribute("matBang", existingMatBang);
        request.getRequestDispatcher("matbang/form.jsp").forward(request, response);
    }

    private void deleteMatBang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        matBangRepository.delete(id);
        response.sendRedirect("matbang");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "save";
        }

        switch (action) {
            case "save":
                saveMatBang(request, response);
                break;
            case "update":
                updateMatBang(request, response);
                break;
        }
    }

    private void saveMatBang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maMb = request.getParameter("maMb");
        int dienTich = Integer.parseInt(request.getParameter("dienTich"));
        String trangThai = request.getParameter("trangThai");
        int tang = Integer.parseInt(request.getParameter("tang"));
        String loaiVp = request.getParameter("loaiVp");
        String moTa = request.getParameter("moTa");
        int gia = Integer.parseInt(request.getParameter("gia"));
        Date ngayBatDau = java.sql.Date.valueOf(request.getParameter("ngayBatDau"));
        Date ngayKetThuc = java.sql.Date.valueOf(request.getParameter("ngayKetThuc"));

        MatBang newMatBang = new MatBang(0, maMb, dienTich, trangThai, tang, loaiVp, moTa, gia, ngayBatDau, ngayKetThuc);
        matBangRepository.save(newMatBang);
        response.sendRedirect("matbang");
    }

    private void updateMatBang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String maMb = request.getParameter("maMb");
        int dienTich = Integer.parseInt(request.getParameter("dienTich"));
        String trangThai = request.getParameter("trangThai");
        int tang = Integer.parseInt(request.getParameter("tang"));
        String loaiVp = request.getParameter("loaiVp");
        String moTa = request.getParameter("moTa");
        int gia = Integer.parseInt(request.getParameter("gia"));
        Date ngayBatDau = java.sql.Date.valueOf(request.getParameter("ngayBatDau"));
        Date ngayKetThuc = java.sql.Date.valueOf(request.getParameter("ngayKetThuc"));

        MatBang updatedMatBang = new MatBang(id, maMb, dienTich, trangThai, tang, loaiVp, moTa, gia, ngayBatDau, ngayKetThuc);
        matBangRepository.update(id, updatedMatBang);
        response.sendRedirect("matbang");
    }
}
