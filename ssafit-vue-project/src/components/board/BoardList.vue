<template>
  <div id="board-container">
    <div id="page-title">
      Board List
      <hr />
    </div>
    <div id="board-list">
      <h5>검색창을 만들 자리입니다</h5>
      <table>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자 ID</th>
          <th>조회수</th>
          <th>등록일</th>
        </tr>
        <tr v-for="board in BoardList" :key="board.boardId">
          <td>{{ board.boardId }}</td>
          <td>
            <RouterLink :to="`/board/${board.boardId}`">{{
              board.title
            }}</RouterLink>
          </td>
          <td>{{ board.userId }}</td>
          <td>{{ board.viewCnt }}</td>
          <td>{{ board.createdAt }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script setup>
import { useBoardStore } from "@/stores/board";
import { onMounted, ref } from "vue";

const store = useBoardStore();
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
  flex-direction: row;
  flex-wrap: wrap;
}

hr {
  width: 100%;
}
</style>
