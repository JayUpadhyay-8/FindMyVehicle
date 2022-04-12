<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    
<script src="https://cdn.jsdelivr.net/npm/chart.js@2/dist/Chart.min.js"></script>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
   <link rel="icon" type="image/png" sizes="16x16" href="<%=request.getContextPath()%>/assets/images/logo-light-icon.png">
        <title>FindMyVehicle</title>
             <%--  <script src="<%=request.getContextPath()%>/adminResources/js/html5shiv.js"></script> --%>
        <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="admin.html">FindMyVehicle</a><button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button
            ><!-- Navbar Search-->
             <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
            <!--    <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" />
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
                    </div>
                </div>-->
            </form>
             <!-- Navbar-->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <!-- <a class="dropdown-item" href="#">Settings</a><a class="dropdown-item" href="#">Activity Log</a>
                        <div class="dropdown-divider"></div>
                         --><a class="dropdown-item" href="login.html">Logout</a>
                    </div>
                </li>
            </ul>
        </nav>

<jsp:include page="menu.jsp"></jsp:include>




            </div>
 	           <div id="layoutSidenav_content">
	<main>
	            <div class="container-fluid">
           <!--  <center class="mx-auto">
				<h1 class="text-muted my-auto">Something awesome is Coming soon..</h1>
				
				<p id="demo" style="font-size:30px"></p>
				
			</center> -->
	      <div class="row">

                <div class="card-group col-lg-12 col-md-12">
                    <!-- Column -->
                    <div class="card col-lg-6 col-md-6">
                        <div class="card-body text-center">
                            <h4 class="text-center text-info">Vehicle's Towed Today</h4>
                            <h2>215</h2>
                            <div class="row p-t-10 p-b-10">
                                <!-- Column -->
                                <div class="col text-center align-self-center">
                                    <div data-label="30%" class="css-bar m-b-0 css-bar-primary css-bar-40">
                                        <i class="display-2 mdi mdi-account-circle"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 col-sm-12">
                                    <h4 class="font-medium m-b-0">
                                        <i class="ti-angle-up text-success"></i>
                                   <!--      <br> 14056</h4>
                                 --></div>
                                <div class="col-md-6 col-sm-12">
                                    <h4 class="font-medium m-b-0">
                                        <i class="ti-angle-down text-danger"></i>
                               <!--          <br> 1433</h4>
                                --> </div>
                            </div>
                        </div>
                    </div>
                    <div class="card col-lg-6 col-md-6">
                        <div class="card-body text-center">
                            <h4 class="text-center text-danger">Towed Vehicle's This Month</h4>
                            <h2>5116</h2>
                            <div class="row p-t-10 p-b-10">
                                <!-- Column -->
                                <div class="col text-center align-self-center">
                                    <div data-label="20%" class="css-bar m-b-0 css-bar-danger css-bar-20">
                                        <i class="display-6 mdi mdi-star-circle"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 col-sm-12">
                                    <h4 class="font-medium m-b-0">
                                        <i class="ti-angle-up text-success"></i>
                              <!--           <br> 21456</h4>
                               -->  </div>
                                <div class="col-md-6 col-sm-12">
                                    <h4 class="font-medium m-b-0">
                                        <i class="ti-angle-down text-danger"></i>
                              <!--           <br> 145</h4>
                               -->  </div>
                            </div>
                        </div>
                    </div>
                    <!-- Column -->
                    <!-- Column -->
<!--                     <div class="card col-lg-4 col-md-4">
                        <div class="card-body text-center">
                            <h4 class="text-center text-cyan">Active Users</h4>
                            <h2>1200</h2>
                            <div class="row p-t-10 p-b-10">
                                Column
                                <div class="col text-center align-self-center">
                                    <div data-label="20%" class="css-bar m-b-0 css-bar-success css-bar-75">
                                        <i class="display-6 mdi mdi-briefcase-check"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 col-sm-12">
                                    <h4 class="font-medium m-b-0">
                                        <i class="ti-angle-up text-success"></i>
                                        <br> 12465</h4>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                    <h4 class="font-medium m-b-0">
                                        <i class="ti-angle-down text-danger"></i>
                                        <br> 145</h4>
                                </div>
                            </div>
                        </div>
                    </div>
 -->                    <!-- Column -->
                </div>
      </div>
                    <!-- Column -->
                  
                <!-- ============================================================== -->
                <!-- Active user - project- visitors -->
                <!-- ============================================================== -->
  	           </div>
             
           <div class="row ">
                 <div class="card col-lg-6 col-md-6 ">
                            <div class="card-body">
                                <h4 class="card-title">Monthly Stats</h4>
                  
           	<div class="col-lg-12">
             <canvas id="myChart" width="100" height="100"></canvas>
             </div>
            </div>
            </div>
<script>
var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
</script>
			 <div class="card col-lg-6 col-md-6 ">
                            <div class="card-body">
                                <h4 class="card-title">Area Wise Details</h4>
           
           	<div class="col-lg-12">
             <canvas id="myChart1" width="100" height="100"></canvas>
             </div>
            </div>
            </div>
            </div>
<script>
var ctx1 = document.getElementById('myChart1').getContext('2d');
var myChart1 = new Chart(ctx1, {
    type: 'pie',
    data: {
        labels: ['Naranpura', 'Bodakdev', 'Mithakadi', 'Thaltej','Maninagar','Panjrapol'],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
</script>
	
	
	</main>

<jsp:include page="footer.jsp"></jsp:include>

            </div>
        </div>
        
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath()%>/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath()%>/assets/demo/chart-area-demo.js"></script>
        <script src="<%=request.getContextPath()%>/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath()%>/assets/demo/datatables-demo.js"></script>
    </body>
</html>
    