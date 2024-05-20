<template>
    <div id="board-container">
        <div id="page-title">
            게시글 상세보기
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
                        {{ store.board.userId }}
                    </div>
                    <div class="board-datetime">
                        {{ store.board.createdAt }}
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
                    <button @click="" class="board-list-button">
                        목록
                    </button>
                </div>
                <div class="board-content-line">
                    &nbsp;
                </div>
            </div>
        </div>
        <div class="d-flex justify-content-center">
            <div class="card" style="width: 30rem">
                <div class="card-body">
                    <div class="mb-3 d-flex justify-content-between align-items-center">
                        <h4 class="card-title">{{ store.board.title }} <span class="badge bg-danger">{{ store.board.viewCnt
                        }}</span></h4>
                        <div class="d-flex justify-content-end">
                            <h6 class="card-subtitle mx-3 text-body-secondary">{{ store.board.userId }}</h6>
                            <h6 class="card-subtitle text-body-secondary">{{ store.board.createdAt }}</h6>
                        </div>
                    </div>
                    <p class="card-text ">
                        {{ store.board.content }}
                    </p>
                    <div class="d-flex justify-content-center">
                        <button class="mx-3 btn btn-outline-success" @click="moveUpdate">수정</button>
                        <button class="mx-3 btn btn-outline-danger" @click="deleteBoard">삭제</button>
                    </div>
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
const route = useRoute();
const router = useRouter();
const store = useBoardStore();

onMounted(() => {
    store.getBoard(route.params.id);
});

const moveUpdate = function () {
    router.push({ name: "boardUpdate" });
};

const deleteBoard = function () {
    axios
        .delete(`http://localhost:8080/ssafit/board/${route.params.boardId}`)
        .then(() => {
            router.push({ name: "boardList" });
        })
        .catch(() => { });
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
    width: 80%
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
    font-weight: 700;
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

.board-list-button {
    display: inline-block;
    margin-bottom: 0;
    padding: 6px 14px;
    outline: 0px;
    border: 1px solid rgba(0, 0, 0, 0);
    background: #FFFFFF;
    color: #929397;
    border-color: #929397;
    text-align: center;
    cursor: pointer;
    font-size: 16px;
    font-weight: normal;
    font-style: normal;
    text-decoration: none;
}
</style>
  