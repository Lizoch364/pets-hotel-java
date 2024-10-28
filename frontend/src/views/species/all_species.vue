<script setup>
import { onMounted, ref } from "vue";
import { getAllSpecies } from "../../api/species";

const species = ref([]);

onMounted(async () => {
  await fetchData();
});

const fetchData = async () => {
  species.value = (await getAllSpecies()) ?? [];
};
</script>

<template>
  <main class="container">
    <div class="d-flex justify-content-between align-items-center w-100">
      <h2 class="h2">Виды животных</h2>
    </div>

    <table class="table">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Имя</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="specie in species" :key="specie.id">
          <th scope="row">{{ specie.id }}</th>
          <td>{{ specie.name }}</td>
        </tr>
      </tbody>
    </table>
  </main>
</template>
