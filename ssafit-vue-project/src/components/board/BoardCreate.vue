<template>
    <div id="board-container">
        <div id="page-title">
            자유게시판
            <hr />
        </div>
        <div class="board-create-view-body">
            <div class="board-create-view-wrap">
                <div class="board-title">
                    <input type="text" class="input-title" placeholder="제목을 입력해주세요." v-model="board.title">
                </div>
                <div class="board-view-info">
                    <div class="board-userId">
                        작성자 : {{ userId }}
                    </div>
                    <div class="board-datetime">
                        작성시간 : {{ writeTime }}
                    </div>
                </div>
                <div class="board-content-line">
                    &nbsp;
                </div>
                <textarea @input="resize($event)" class="input-content" placeholder="내용을 입력해주세요." v-model="board.content" />
                <div class="board-content-line">
                    &nbsp;
                </div>
                <div class="board-list-button-wrapper">
                    <button @click="createBoard" class="board-create-button">
                        등록
                    </button>
                    <button @click="moveList" class="board-list-button">
                        취소
                    </button>
                </div>
                <div class="board-content-line">
                    &nbsp;
                </div>
            </div>
        </div>
    </div>
</template>
  
<script setup>
import { useRouter } from "vue-router";
import { ref, onMounted } from "vue";
import { useBoardStore } from "@/stores/board";
const router = useRouter();
const store = useBoardStore();

const props = defineProps({
    userId: String
});

const writeTime = ref("");

const monthNamesToNumbers = {
    "January": "01",
    "February": "02",
    "March": "03",
    "April": "04",
    "May": "05",
    "June": "06",
    "July": "07",
    "August": "08",
    "September": "09",
    "October": "10",
    "November": "11",
    "December": "12"
};

function convertMonthNameToNumber(monthName) {
    return monthNamesToNumbers[monthName] || null;
}

const serverTime = function () {
    var xmlHttp;

    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject('Msxml12.XMLHTTP');
    }

    xmlHttp.open('HEAD', window.location.href.toString(), false);
    xmlHttp.setRequestHeader("Content-Type", "text/html");
    xmlHttp.send('');

    var curr = xmlHttp.getResponseHeader("Date");

    var date = new Date(curr).toDateString().slice(3);

    var time = new Date(curr).toTimeString().slice(0, 8);

    var year = date.slice(8, 13);

    var month = convertMonthNameToNumber(date.slice(1, 4).toString());

    var day = date.slice(5, 8);

    writeTime.value = year + "-" + month + "-" + day + time;
}

const board = ref({
    title: "",
    content: "",
    userId: props.userId
})

const createBoard = function () {
    if (board.value.title.trim() === "") {
        alert("제목을 입력하세요.");
        return;
    }
    if (board.value.content.trim() === "") {
        alert("내용을 입력하세요.");
        return;
    }
    store.createBoard(board.value)
};

const moveList = function () {
    router.push({ name: "boardList" });
};

const resize = (event) => {
    const textarea = event.target;
    textarea.style.height = 'auto';
    const newHeight = textarea.scrollHeight;
    textarea.style.height = textarea.scrollHeight + 'px';
    window.scrollTo({
        top: window.scrollY + newHeight,
        behavior: "instant"
    });
}

onMounted(() => {
    serverTime();
});
</script>
  
<style scoped>
#board-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 2%;
    height: auto;
}

#page-title {
    font-size: 30px;
    width: 95%;
}

.board-create-view-body {
    width: 80%;
    height: auto;
    max-width: 1000px;
}

.board-create-view-wrap {
    width: 100%;
    height: auto;
}

.board-title {
    margin: 0;
    padding-top: 5px;
    padding-bottom: 5px;
}

.input-title {
    background-color: white;
    border-style: none;
    outline: none;
    font-size: 20px;
    font-weight: 600;
    line-height: 100%;
    padding-left: 10px;
    width: 100%;
}

.board-view-info {
    clear: both;
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    align-items: center;
    justify-content: space-between;
    width: 100%;
    height: auto;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

.board-view-info {
    flex: 0 0 auto;
    margin-top: 5px;
    margin-bottom: 5px;
    padding-left: 5px;
    padding-right: 10px;
}

.board-content-line {
    clear: both;
    width: 100%;
    height: 1px;
    background: #ccc;
    font-size: 0;
    line-height: 0;
    padding: 0;
    margin: 10px 0;
}

.input-content {
    resize: none;
    width: 100%;
    height: auto;
    min-height: 20rem;
    border-style: none;
    outline: none;
    font-size: 16px;
    line-height: 100%;
    padding-left: 10px;
}

.board-list-button-wrapper {
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    align-items: center;
    justify-content: flex-end;
    width: 100%;
    padding: 0 2%;
    margin: 20px 0;
    box-sizing: border-box;
}

.board-create-button {
    border: 1px solid rgba(0, 0, 0, 0);
    background: #FFFFFF;
    color: #1b359c;
    border-color: #1b359c;
}

.board-list-button {
    border: 1px solid rgba(0, 0, 0, 0);
    background: #FFFFFF;
    color: #d12424;
    border-color: #d12424;
}

.board-create-button,
.board-list-button {
    display: inline-block;
    margin-bottom: 0;
    padding: 6px 14px;
    outline: 0px;
    border: 1px solid rgba(0, 0, 0, 0);
    background: #FFFFFF;
    border-color: #929397;
    text-align: center;
    cursor: pointer;
    font-size: 16px;
    font-weight: normal;
    font-style: normal;
    text-decoration: none;
}
</style>
  