        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            
                            <a class="nav-link" href="user.html"
                                ><div class="sb-nav-link-icon"><i class="fas fa-car"></i></div>
                                FindMyVehicle</a>
                            <div class="sb-sidenav-menu-heading">Menu</div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts"
                                ><div class="sb-nav-link-icon"><i class="fas fa-image	"></i></div>
                                Manage Image
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                            ></a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav"><a class="nav-link" href="addImageUserUpload.html">Add Image</a></nav>
                            </div>

					


					<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages"
                                ><div class="sb-nav-link-icon"><i class="fas fa-user-circle"></i></div>
                                Manage Account
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                            ></a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link" href="editRegister.html?x=${uname}">Change Password</a>
                                        
                                       
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading"></div>
                           <!--  <a class="nav-link" href="charts.html"
                                ><div class="sb-nav-link-icon"></div>
                                </a
                            ><a class="nav-link" href="tables.html"
                                ><div class="sb-nav-link-icon"></div>
                                </a
                            > -->
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        User :${uname }
                    </div>
                </nav>