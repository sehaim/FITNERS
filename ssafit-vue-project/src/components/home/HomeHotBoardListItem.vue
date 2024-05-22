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
  min-height: 100%;
  padding: 1%;
}

#title {
  font-family: "neodgm";
  font-size: 20px;
  font-weight: 100;
  color: #7696b4;
  height: 27px;
  width: 100%;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

#content {
  height: 70%;
  max-height: 95px;
  width: 100%;
  color: rgb(141, 140, 140);
  display: -webkit-box;
  -webkit-box-orient: vertical;
  overflow: hidden;
  -webkit-line-clamp: 4;
}

hr {
  width: 100%;
  margin: 5px auto;
}
</style>
