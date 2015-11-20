    <script src="<c:url value='/resources/js/changePassword.js'/>" ></script>
<div class="modal fade" id="myModalNorm" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal">
                       <span aria-hidden="true">&times;</span>
                       <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Change Your Password
                </h4>
            </div>
            
            <div class="modal-body">
                  <div class="form-group">
                    <label for="oldPassword">Old Password</label>
                      <input type="password" class="form-control"
                      id="oldPassword"/>
                  </div>
                  <div class="form-group">
                    <label for="newPassword">New Password</label>
                      <input type="password" class="form-control"
                          id="newPassword"/>
                  </div>
                  <div class="form-group">
                    <label for="repeatPassword">Repeat New Password</label>
                      <input type="password" class="form-control"
                          id="repeatPassword"/>
                  </div>
            </div>
            
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">
                            Close
                </button>
                <button id="saveChangedPassword" type="button" class="btn btn-primary" data-dismiss="modal">
                    Save changes
                </button>
            </div>
        </div>
    </div>
</div>