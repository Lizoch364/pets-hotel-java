<script setup>
import { onMounted, ref } from "vue";
import { getAllTypeFeed } from "../../api/typefeed";

const typefeed = ref([]);

onMounted(async () => {
  await fetchData();
});

const fetchData = async () => {
  typefeed.value = (await getAllTypeFeed()) ?? [];
};
</script>

<template>
  <main class="container">
    <div class="d-flex justify-content-between align-items-center w-100">
      <h2 class="h2">Типы кормов</h2>
    </div>

    <table class="table">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Имя</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="type in typefeed" :key="type.id">
          <th scope="row">{{ type.id }}</th>
          <td>{{ type.name }}</td>
        </tr>
      </tbody>
    </table>
  </main>
</template>
