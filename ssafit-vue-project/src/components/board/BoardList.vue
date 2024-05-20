<template>
  <div id="board-container">
    <div id="page-title">
      Board List
      <hr />
    </div>
    <div id="board-list">
      <div class="search">
        <h5>검색창을 만들 자리입니다</h5>
      </div>
      <div>
        <div class="board-list-items">
          <div class="board-list-name">
            <div class="board-item-title">
              제목
            </div>
            <div class="board-item-writer">
              작성자
            </div>
            <div class="board-item-datetime">
              작성일
            </div>
            <div class="board-item-view-count">
              조회수
            </div>
          </div>
          <div v-for="board in store.boardList" :key="board.boardId" class="board-list-item">
            <div class="board-item-title">
              <RouterLink :to="`/board/${board.boardId}`">
                {{ board.title }}
              </RouterLink>
            </div>
            <div class="board-item-writer">
              {{ board.userId }}
            </div>
            <div class="board-item-datetime">
              {{ sliceDateTime(board.createdAt) }}
            </div>
            <div class="board-item-view-count">
              {{ board.viewCnt }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useBoardStore } from "@/stores/board.js";
import { onMounted, ref } from "vue";

const store = useBoardStore();

const sliceDateTime = function (schedule) {
  return schedule.slice(2, 16);
};

onMounted(() => {
  store.getBoardList();
});
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

#board-list {
  display: flex;
  justify-content: center;
  flex-direction: column;
  flex-wrap: wrap;
  width: 70%;
}

hr {
  width: 100%;
}

.search {
  text-align: center;
  margin-top: 10px;
  margin-bottom: 20px;
}

.board-list-items {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: center;
  width: 100%;
  height: auto;
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  border-top: 2px solid #535353;
  border-bottom: 1px solid #535353;
}

.board-list-item,
.board-list-name {
  flex: 0 0 auto;
  position: relative;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  align-items: center;
  justify-content: flex-start;
  width: 100%;
  height: auto;
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.board-list-name>div {
  font-weight: bold;
  margin-top: 10px;
  margin-bottom: 10px;
}

.board-list-item {
  background-image: -webkit-linear-gradient(left, #b4b4b4, #b4b4b4 1px, transparent 1px, transparent 3px);
  background-image: linear-gradient(to right, #b4b4b4, #b4b4b4 1px, transparent 1px, transparent 3px);
  background-repeat: repeat-x;
  background-position: left top;
  background-size: 4px 1px;
}

.board-list-item div {
  display: block;
  height: auto;
  margin: 0;
  padding: 15px 0 20px 0;
  font-weight: 400;
  color: #333;
  box-sizing: border-box;
}

.board-item-title {
  width: 50%;
  text-align: left;
  padding-left: 15px;
}

.board-item-title>a {
  padding-left: 5px;
}

.board-item-writer {
  width: 20%;
  text-align: center;
}

.board-item-datetime {
  width: 20%;
  text-align: center;
}

.board-item-view-count {
  width: 10%;
  text-align: center;
}
</style>
