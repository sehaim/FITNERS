<template>
    <div>
        <h4>게시글 목록</h4>
        <hr />
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
                    <RouterLink :to="`/board/${board.boardId}`">{{ board.title }}</RouterLink>
                </td>
                <td>{{ board.userId }}</td>
                <td>{{ board.viewCnt }}</td>
                <td>{{ board.createdAt }}</td>
            </tr>
        </table>
    </div>
</template>
  
<script setup>
import { useBoardStore } from '@/stores/board';
import { onMounted, ref } from 'vue';

const store = useBoardStore();
onMounted(() => {
  store.getBoardList();
});

</script>
  
<style scoped></style>
  