<template>
  <div id="club-board-detail-container">
    <div id="board-detail">
      <div id="board-title">
        <div id="title">{{ store.clubBoard.title }}</div>
        <div id="board-manager-btn" v-if="store.loginUser.isManager">
          <button>수정</button>
        </div>
      </div>
      <hr />
      <div id="board-created">{{ sliceDate(store.clubBoard.createdAt) }}</div>
      <div id="board-content">
        <div id="content">{{ store.clubBoard.content }}</div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useClubStore } from "@/stores/club.js";

const store = useClubStore();

onMounted(() => {
  store.getClubBoard();
})


const sliceDate = function (date) {
  if(date != null) {
    return date.toString().slice(0,10);
  }
}
</script>

<style scoped>
#board-detail {
  height: 50vh;
  display: flex;
  flex-direction: column;
  padding: 3%;
  justify-content: space-between;
}

#title {
  font-size: 22px;
  border-width: 900;
}

hr {
  width: 100%;
}

#board-created {
  color: rgb(87, 86, 86);
  text-align: right;
}

#board-content {
  height: 60%;
  border-style: dashed;
  border-color: rgb(230, 224, 224);
  border-radius: 20px;
  display: flex;
  flex-direction: row;
  align-items: center;
}

#content {
  margin: auto;
  font: 17px;
}
</style>