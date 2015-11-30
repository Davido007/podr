<div class="modal fade" id="addNewPlaceModal" tabindex="-1" role="dialog" aria-labelledby="profileImageModal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Add New Place
                </h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label id="addNewPlaceLabel" class="col-xs-3 control-label">From:</label>
                    <div id="newPlaceDatePicker" class="col-xs-5 date">
                        <div class="input-group input-append date startDataPicker" id="datePicker">
                            <input id="startDate" type="text" class="form-control" name="date" />
                            <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                    </div>
                    <label id="addNewPlaceLabel" class="col-xs-3 control-label">To:</label>
                    <div id="newPlaceDatePicker" class="col-xs-5 date">
                        <div class="input-group input-append date endDataPicker" id="datePicker">
                            <input id="endDate" type="text" class="form-control" name="date" />
                            <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                    </div>
                </div>
                </br>
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text" class="form-control" id="title"/>
                </div>
                <div class="form-group">
                    <label for="note">Note:</label>
                    <textarea id="note" class="form-control" rows="4" id="comment"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    Close
                </button>
                <button id="saveNewPlace" type="button" class="btn btn-primary" >
                    Save changes
                </button>
            </div>
        </div>
    </div>
</div>
