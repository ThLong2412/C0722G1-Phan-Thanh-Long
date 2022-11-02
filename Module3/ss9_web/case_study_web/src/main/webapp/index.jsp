<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/2/2022
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>FURAMA RESORT ĐÀ NẴNG CITY</title>
    <style>
      #header1 {
        background-image: url("https://dichoinhatrang.net/wp-content/uploads/2022/04/Banner-Sayhi-1.gif");
      }

      #img2 {
        background-image: url("https://img.freepik.com/free-photo/beautiful-luxury-outdoor-swimming-pool-hotel-resort_74190-7433.jpg?w=2000");
      }
    </style>
    <link rel="stylesheet" href="../bootstrap-5.0.2-dist/css/bootstrap.css">
    <link rel="stylesheet" href="case_study.css">
  </head>
  <body>
  <div class="header row" id="header1">
    <div class="col-lg-2 ">
      <div>
        <div style="margin-left: 20px; width: 50px; height: 50px">
          <img id="img1" src="https://cardy.vn/upload/images/h19/images/640x480/2/logofura.jpg" alt="">
        </div>
        <div style="margin-left: 20px">Furama</div>
      </div>
    </div>
    <div class="col-lg-8"></div>
    <div class="col-lg-2 left-header"><p>Phan Thanh Long</p></div>
  </div>
  <div class="container-fluid" style="padding: 0">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link" href="D:\Codegym\Module3\case_study_web\case_study.html">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Employee</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Customer</a>
            </li>
            <div class="dropdown">
              <button  class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                Service
              </button>
              <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                <li><a class="dropdown-item" href="D:\Codegym\Module3\case_study_web\service_list.html  ">Service List</a></li>
                <li><a class="dropdown-item" href="#">Create Service</a></li>
                <li><a class="dropdown-item" href="#">Edit Service</a></li>
                <li><a class="dropdown-item" href="#">Remove Service</a></li>
              </ul>
            </div>
            <li class="nav-item">
              <a class="nav-link" href="#">Contract</a>
            </li>
          </ul>
          <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
          </form>
        </div>
      </div>
    </nav>
  </div>
  <div class="row" style=" margin: 0; padding: 0; ">
    <div class=" col-lg-2 " style=" margin: 0; padding: 0;">
      <div class="list-group">
        <a href="https://furamavietnam.com/vi/furama-special-offers/" class="list-group-item list-group-item-action"
           aria-current="true">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">ƯU ĐÃI FURAMA</h5>
            <small>3 days ago</small>
          </div>
          <p class="mb-1">Some placeholder content in a paragraph.</p>
          <small>And some small print.</small>
        </a>
        <a href="https://furamavietnam.com/vi/culinary/" class="list-group-item list-group-item-action">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">ẨM THỰC ĐA DẠNG</h5>
            <small class="text-muted">3 days ago</small>
          </div>
          <p class="mb-1">Some placeholder content in a paragraph.</p>
          <small class="text-muted">And some muted small print.</small>
        </a>
        <a href="https://furamavietnam.com/vi/meeting-and-events/" class="list-group-item list-group-item-action">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">HỘI NGHỊ VÀ SỰ KIỆN CAO CẤP</h5>
            <small class="text-muted">3 days ago</small>
          </div>
          <p class="mb-1">Some placeholder content in a paragraph.</p>
          <small class="text-muted">And some muted small print.</small>
        </a>
        <a href="https://furamavietnam.com/vi/our-rooms/" class="list-group-item list-group-item-action">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">LOẠI PHÒNG</h5>
            <small class="text-muted">3 days ago</small>
          </div>
          <p class="mb-1">Some placeholder content in a paragraph.</p>
          <small class="text-muted">And some muted small print.</small>
        </a>
        <a href="https://furamavietnam.com/vi/spa-and-fitness/" class="list-group-item list-group-item-action">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">DỊCH VỤ SPA VÀ THỂ THAO</h5>
            <small class="text-muted">3 days ago</small>
          </div>
          <p class="mb-1">Some placeholder content in a paragraph.</p>
          <small class="text-muted">And some muted small print.</small>
        </a>
        <a href="https://furamavietnam.com/vi/recreation/" class="list-group-item list-group-item-action">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">GIẢI TRÍ</h5>
            <small class="text-muted">3 days ago</small>
          </div>
          <p class="mb-1">Some placeholder content in a paragraph.</p>
          <small class="text-muted">And some muted small print.</small>
        </a>
      </div>
    </div>
    <div class=" col-lg-10" style=" margin: 0; padding: 0;" id="img2">

    </div>
  </div>

  <div class="footer" style="background-color: aqua; display: flex;
justify-content: center; align-items: center">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 col-light">
          <h2 class="mb-1">Hướng Dẫn Di Chuyển</h2>
          <div class="d-flex flex-column flex-md-row flex-lg-column">
            <p>Khu nghỉ dưỡng Furama là cơ sở hàng đầu để khám phá một trong những điểm đến hấp dẫn nhất Châu Á.
              Chỉ cách Đà Nẵng một quãng lái xe ngắn là bốn Di sản Văn hóa Thế giới được UNESCO công nhận:</p>
          </div>
          <div class="mt-3 mt-md-1 mt-lg-3"></div>
          <h4 class="mb-1 mb-md-2">Địa Điểm</h4>
          <table class="place-table">
            <tbody>
            <tr>
              <td>1.</td>
              <td>Cố đô Huế</td>
              <td class="text-right"><span>2 tiếng</span></td>
            </tr>
            <tr>
              <td>2.</td>
              <td>Phố cổ Hội An</td>
              <td class="text-right"><span>30 phút</span></td>
            </tr>
            <tr>
              <td>3.</td>
              <td>Thánh địa Mỹ Sơn</td>
              <td class="text-right"><span>90 phút</span></td>
            </tr>
            <tr>
              <td>4.</td>
              <td>Động Phong Nha</td>
              <td class="text-right"><span>3 tiếng</span></td>
            </tr>
            </tbody>
          </table>
        </div>
        <div class="col-lg-7 ml-lg-auto d-flex flex-column position-static">
          <div class="row">
            <div class="col-sm col-lg-5">
              <div id="nav_menu-1" class="footer-widget4  widget_nav_menu">
                <div class="menu-footer-menu-vi-container">
                  <ul id="menu-footer-menu-vi" class="menu">
                    <li id="menu-item-6855"
                        class="menu-item menu-item-type-post_type menu-item-object-page menu-item-6855">
                      <a href="https://furamavietnam.com/vi/furama-resort-danang-rack-rate/">Giá Công
                        Bố</a></li>
                    <li id="menu-item-6854"
                        class="menu-item menu-item-type-post_type menu-item-object-page menu-item-6854">
                      <a href="https://furamavietnam.com/vi/lifestyle-blog/">Lifestyle Blog</a></li>
                    <li id="menu-item-6856"
                        class="menu-item menu-item-type-post_type menu-item-object-page menu-item-6856">
                      <a href="https://furamavietnam.com/vi/work-with-us/">Tuyển Dụng</a></li>
                    <li id="menu-item-6857"
                        class="menu-item menu-item-type-post_type menu-item-object-page menu-item-6857">
                      <a href="https://furamavietnam.com/vi/contact/">Liên Hệ</a></li>
                  </ul>
                </div>
              </div>
              <div id="text-5" class="footer-widget4  widget_text">
                <div class="textwidget"></div>
              </div>
            </div>
            <div class="col-sm mt-2 mt-sm-0">
              <h4>
                Liên hệ </h4>
              <ul class="icn-list">
                <li><i class="icon-placeholder"></i><span style="color: #707070;font-size: 12px">103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam</span><br
                        style="margin: 0;padding: 0;color: #707070;font-size: 12px"/>
                  <span
                          style="color: #707070;font-size: 12px">Tel.: 84-236-3847 333/888 *
                                </span>
                  <span style="color: #707070;font-size: 12px">Fax: 84-236-3847 666
                                </span>
                  <br
                          style="margin: 0;padding: 0;color: #707070;font-size: 12px"/>
                  <span
                          style="color: #707070;font-size: 12px">Email:
                                </span>
                  <a class="link"
                     style="margin: 0;padding: 0 ;color: #707070;font-size: 12px"
                     href="mailto:reservation@furamavietnam.com">reservation@furamavietnam.com
                  </a>
                  <span
                          style="color: #707070;font-size: 12px"> *
                                </span>
                  <a class="link" style="margin: 0;padding: 0;color: #707070;font-size: 12px"
                     href="https://www.furamavietnam.com/undefined/">www.furamavietnam.com
                  </a>
                  <span style="color: #707070;font-size: 12px">GDS Codes: Amadeus-GD DADFUR, Galileo/Apollo-GD 16236, Sabre-GD 032771, Worldspan- GD DADFU</span>

                  <hr/>

                  <a href="https://www.facebook.com/furamaresort/" target="_blank" rel="noopener"><img
                          style="width: 32px;height: 32px;float: left"
                          src="https://furamavietnam.com/wp-content/uploads/2019/06/incon-Facbook-1.png"
                          alt="" width="32" height="32"/></a><a
                          href="https://www.instagram.com/furama_resort_danang/?hl=vi" target="_blank"
                          rel="noopener"><img style="width: 40px;height: 32px;float: left"
                                              src="https://furamavietnam.com/wp-content/uploads/2019/06/social-ins.png"
                                              alt="" width="40" height="32"/></a><a
                          href="https://www.youtube.com/user/furamaresortvietnam/featured" target="_blank"
                          rel="noopener"><img style="width: 40px;height: 32px;float: left"
                                              src="https://furamavietnam.com/wp-content/uploads/2021/10/social-youtube.png"
                                              alt="" width="40" height="32"/></a></li>
              </ul>
            </div>
          </div>
          <div class="row mt-5 mb-1 mt-lg-auto mb-md-0 align-items-center">
            <div class="col-sm-auto col-lg-12 col-xl-auto">
              <div class="footer-copyright text-left">
                <img src="https://furamavietnam.com/wp-content/uploads/2019/02/Ariyana-Tourism-Complex-02-2.png"
                     alt="Ariyana Tourism Complex" width="500px;">
                <div class="clearfix d-md-none"></div>
                © 2018 Furama Danang.
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="../bootstrap-5.0.2-dist/js/bootstrap.js"></script>
  </body>
</html>
