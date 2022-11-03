// write.js

let count = 0;
$("#fileAddBtn").click(function() {

    // 파일폼 추가
    let fileAdd = '<div>';
    fileAdd = fileAdd + '<input type="file" name="files"></input>';
    fileAdd = fileAdd + '<button type="button" class="del">삭제</button>';
    fileAdd = fileAdd + '</div>';

    if (count < 5) {
        $("#fileAddForm").append(fileAdd);
        count++;
    }

    else {
        $("#fileAddCheck").html("파일은 최대 5개까지만 가능합니다.");

        return false;
    }

});

// 파일폼 삭제
$("#fileAddForm").on("click", ".del", function() {
    $(this).parent().remove();
    $("#fileAddCheck").html("");

    count--;
})