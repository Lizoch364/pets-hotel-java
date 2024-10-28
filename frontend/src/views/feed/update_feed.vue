<script setup>
import { onMounted, ref } from "vue";
import { useRoute, useRouter } from "vue-router";

import { updateFeed, getOneFeed } from "../../api/feeds";
import FeedForm from "../../components/feed_form.vue";

const route = useRoute();
const router = useRouter();

const initialData = ref(null);

onMounted(async () => {
  initialData.value = await getOneFeed(route.params.id);
});

const handleSubmit = async (data) => {
  await updateFeed({
    ...initialData.value,
    ...data,
  });

  router.push({ name: "all_feeds" });
};
</script>

<template>
  <main class="container">
    <h3>Обновление</h3>
    <FeedForm v-if="initialData" :initial-data="initialData" @submit="handleSubmit" button-text="Обновить" />
  </main>
</template>
