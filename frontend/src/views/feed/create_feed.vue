<script setup>
import { useRouter } from "vue-router";

import { createFeed } from "../../api/feeds";
import FeedForm from "../../components/feed_form.vue";

const router = useRouter();

const handleSubmit = async (data) => {
  await createFeed({
    ...data,
  });

  router.push({ name: "all_feeds" });
};
</script>

<template>
  <main class="container">
    <h3>Создание</h3>
    <FeedForm @submit="handleSubmit" button-text="Создать" />
  </main>
</template>
