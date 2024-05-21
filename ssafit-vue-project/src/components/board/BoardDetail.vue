<template>
    <div id="board-container">
        <div id="page-title">
            자유게시판
            <hr />
        </div>
        <div class="board-detail-view-body">
            <div class="board-datail-view-wrap">
                <div class="board-title">
                    <span class="board-title-text">
                        {{ store.board.title }}
                    </span>
                </div>
                <div class="board-view-info">
                    <div class="board-userId">
                        작성자 : {{ store.board.userId }}
                    </div>
                    <div class="board-datetime">
                        작성시간 : {{ store.board.createdAt }}
                    </div>
                </div>
                <div class="board-content-line">
                    &nbsp;
                </div>
                <div class="board-content">
                    {{ store.board.content }}
                </div>
                <div class="board-content-line">
                    &nbsp;
                </div>
                <div class="board-list-button-wrapper">
                    <button v-if="store.loginUser !== null && store.board.userId == store.loginUser.userId" @click="moveUpdate"
                        class="board-update-button">
                        수정
                    </button>
                    <button v-if="store.loginUser !== null && store.board.userId == store.loginUser.userId" @click="deleteBoard"
                        class="board-delete-button">
                        삭제
                    </button>
                    <button @click="moveList" class="board-list-button">
                        목록
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
import { useRoute, useRouter } from "vue-router";
import { ref, onMounted } from "vue";
import { useBoardStore } from "@/stores/board";
import axios from "axios";
import BoardList from "./BoardList.vue";
const route = useRoute();
const router = useRouter();
const store = useBoardStore();

onMounted(() => {
    store.getBoard(route.params.id);
});

const moveUpdate = function () {
    router.push({
        name: 'boardUpdate',
        query: {
            boardId: store.board.boardId,
            title: store.board.title, 
            content: store.board.content,
            userId: store.board.userId,
            writeTime: store.board.createdAt
        }
    });
};

const deleteBoard = function () {
    store.deleteBoard(store.board.boardId);
};

const moveList = function () {
    router.push({ name: "boardList" });
};
</script>
  
<style scoped>
#board-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 2%;
}

#page-title {
    font-size: 30px;
    width: 95%;
}

.board-detail-view-body {
    width: 80%;
    max-width: 1000px;
}

.board-datail-view-wrap {
    width: 100%;
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

.board-content {
    clear: both;
    width: 100%;
    max-width: 100%;
    height: auto;
    margin: 0;
    padding: 30px 2%;
    font-size: 16px;
    line-height: 190%;
    color: #000;
    word-wrap: break-word;
    word-break: break-all;
    box-sizing: border-box;
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


.board-delete-button {
    border: 1px solid rgba(0, 0, 0, 0);
    background: #FFFFFF;
    color: #d12424;
    border-color: #d12424;
}

.board-list-button {
    border: 1px solid rgba(0, 0, 0, 0);
    background: #FFFFFF;
    color: #929397;
    border-color: #929397;

}

.board-update-button,
.board-delete-button,
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
}</style>
  