<script setup>
import { useRouter } from "vue-router";

import { createOwner } from "../../api/owners";
import OwnerForm from "../../components/owner_form.vue";

const router = useRouter();

const handleSubmit = async (data) => {
  await createOwner({
    ...data,
  });

  router.push({ name: "all_owners" });
};
</script>

<template>
  <main class="container">
    <h3>Создание</h3>
    <OwnerForm @submit="handleSubmit" button-text="Создать" />
  </main>
</template>
