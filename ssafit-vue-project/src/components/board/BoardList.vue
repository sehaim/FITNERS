<template>
  <div id="board-container">
    <div id="page-title">
      Board List
      <hr />
    </div>
    <div id="board-list">
      <div class="board-header">
        <div class="search">
          <div>
            <input type="text" class="input-keyword" placeholder="제목으로 검색" v-model="search.title">
            <button @click="searchBoardList" class="board-search-button">
              검색
            </button>
          </div>
        </div>
        <div v-if="store.loginUser !== null" class="insert">
          <button @click="moveCreateBoard" class="board-write-button">
            게시글 등록
          </button>
        </div>
      </div>
      <div v-if="store.doSearch" class="board-header-search">
        <div class="search-notice">
          <span>
            검색 결과
          </span>
        </div>
      </div>
      <div>
        <div class="board-list-items">
          <div v-if="store.doSearch && store.noSearchResult" class="board-list-nosearchresult">
            <div class="search-notice-result">
              <span>
                검색 결과가 없습니다.
              </span>
            </div>
          </div>
          <div v-if="store.boardList.length > 0" class="board-list-name">
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
import { useRouter } from 'vue-router';

const store = useBoardStore();

const router = useRouter();

const sliceDateTime = function (schedule) {
  return schedule.slice(2, 16);
};

const search = ref({
  title: ""
})

const searchBoardList = function () {
  if (search.value.title.trim() === "") {
    alert("검색어를 입력하세요.");
    return;
  }
  store.searchBoardList(search.value.title);
}

const moveCreateBoard = function () {
  router.push({
    name: 'boardCreate',
    query: { userId: store.loginUser.userId }
  });
}

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

.search,
.insert {
  text-align: center;
  /* margin-top: 10px;
  margin-bottom: 10px; */
  margin: 10px;
}

.board-header {
  display: flex;
  flex-direction: row-reverse;
  justify-content: space-between;
  margin-top: 10px;
  margin-bottom: 5px;
}

.board-header-search {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 5px;
  padding-bottom: 5px;
}

.search-notice,
.search-notice-result {
  padding-bottom: 5px;
  font-size: 20px;
}

.input-keyword {
  display: inline-block;
  margin-bottom: 0;
  margin-right: 5px;
  padding: 6px 14px;
  outline: 0px;
  border: 1px solid rgba(0, 0, 0, 0);
  background: #FFFFFF;
  border-color: #929397;
  font-size: 16px;
  font-weight: normal;
  font-style: normal;
  text-decoration: none;
}

.board-write-button,
.board-search-button {
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

.board-list-nosearchresult {
  display: flex;
  flex-direction: row;
  justify-content: center;
  width: 100%;
  height: auto;
  margin-top: 20px;
  margin-bottom: 20px;
  padding: 0;
  box-sizing: border-box;
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
