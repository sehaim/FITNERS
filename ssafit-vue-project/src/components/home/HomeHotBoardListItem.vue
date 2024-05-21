<template>
  <div id="hot-board-list-item-container">
    <RouterLink id="title" :to="`/board/${hotBoard.boardId}`">{{
      hotBoard.title
    }}</RouterLink>
    <hr />
    <div id="content">{{ hotBoard.content }}</div>
  </div>
</template>

<script setup>
defineProps({
  hotBoard: Object,
});
</script>

<style scoped>
#hot-board-list-item-container {
  display: flex;
  flex-direction: column;
  width: 25%;
  height: 100%;
  padding: 1%;
}

#title {
  font-size: 20px;
  color: #276699;
  height: 30px;
  width: 100%;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

#content {
  color: rgb(141, 140, 140);
  overflow: hidden;
  text-overflow: ellipsis;
}

hr {
  width: 100%;
  margin: 5px auto;
}
</style>
