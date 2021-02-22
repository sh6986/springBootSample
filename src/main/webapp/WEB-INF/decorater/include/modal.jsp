<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Modal body text goes here.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Save changes</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fileModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title originName"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p class="fileDesc"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary modify">수정</button>
                <button type="button" class="btn btn-primary download">다운로드</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>





<div class="modal" id="signUp">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">회원 가입</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">


                <form>
                    <fieldset>
                        <div class="form-group">
                            <label for="IptMemId">ID</label>
                            <input type="email" class="form-control" id="IptMemId" aria-describedby="emailHelp" placeholder="Enter Id">
                            <small class="form-text text-muted">32자 이상의 아이디는 불가능 합니다.</small>
                        </div>
                        <div class="form-group">
                            <label for="IptMemPwd">Password</label>
                            <input type="password" class="form-control" id="IptMemPwd" placeholder="Password">
                            <small  class="form-text text-muted">대문자 소문자 숫자로 이루어진 3자 이상의 비밀번호만 가능합니다.</small>
                        </div>

                    </fieldset>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary download">sign up</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>



