<template>
    <div id="board-container">
        <div id="page-title">
            자유게시판
            <hr />
        </div>
        <div class="board-update-view-body">
            <div class="board-update-view-wrap">
                <div class="board-title">
                    <span class="board-title-text">
                        {{ props.title }}
                    </span>
                </div>
                <div class="board-view-info">
                    <div class="board-userId">
                        작성자 : {{ props.userId }}
                    </div>
                    <div class="board-datetime">
                        작성시간 : {{ props.writeTime }}
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
                    <button @click="updateBoard" class="board-update-button">
                        수정
                    </button>
                    <button @click="cancel" class="board-cancel-button">
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
    boardId: Number,
    title: String,
    content: String,
    userId: String,
    writeTime: String
});

const board = ref({
    boardId: props.boardId,
    content: props.content
})

const updateBoard = function () {
    if (board.value.content.trim() === "") {
        alert("내용을 입력하세요.");
        return;
    }
    store.updateBoard(board.value)
};

const cancel = () => {
    router.go(-1);
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

.board-update-view-body {
    width: 80%;
    height: auto;
    max-width: 1000px;
}

.board-update-view-wrap {
    width: 100%;
    height: auto;
}

.board-title {
    margin: 0;
    padding-top: 5px;
    padding-bottom: 5px;
}

.board-title-text {
    font-size: 20px;
    font-weight: 600;
    color: #000;
    line-height: 100%;
    padding-left: 10px;
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

.board-update-button {
    border: 1px solid rgba(0, 0, 0, 0);
    background: #FFFFFF;
    color: #1b359c;
    border-color: #1b359c;
}

.board-cancel-button {
    border: 1px solid rgba(0, 0, 0, 0);
    background: #FFFFFF;
    color: #d12424;
    border-color: #d12424;
}

.board-update-button,
.board-cancel-button {
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
  