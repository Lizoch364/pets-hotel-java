<script setup>
import { onMounted, ref } from "vue";
import { deleteFeed, getAllFeeds } from "../../api/feeds";

const feeds = ref([]);

onMounted(async () => {
  await fetchData();
});

const fetchData = async () => {
  feeds.value = (await getAllFeeds()) ?? [];
};

const handleDeleteFeed = async (id) => {
  await deleteFeed(id);
  await fetchData();
};
</script>

<template>
  <main class="container">
    <div class="d-flex justify-content-between align-items-center w-100">
      <h2 class="h2">Корма</h2>
      <div>
        <RouterLink :to="{ name: 'create_feed' }" class="btn btn-primary btn-sm"> Создать </RouterLink>
      </div>
    </div>

    <table class="table">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Название</th>
          <th scope="col">Тип корма</th>
          <th scope="col">Стоимость</th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="feed in feeds" :key="feed.id">
          <th scope="row">{{ feed.id }}</th>
          <td>{{ feed.name }}</td>
          <td>{{ feed.typeFeed.name }}</td>
          <td>{{ feed.price }}</td>
          <td>
            <div class="d-flex gap-1">
              <RouterLink class="btn btn-secondary btn-sm" :to="{ name: 'update_feed', params: { id: feed.id } }">
                Обновить
              </RouterLink>
              <button class="btn btn-outline-danger btn-sm" @click="handleDeleteFeed(feed.id)">Удалить</button>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
  </main>
</template>
