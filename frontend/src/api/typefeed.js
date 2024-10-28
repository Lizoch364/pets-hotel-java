import { http } from "./axios";

const BASE_URL = "/api/v1/hotels/type-feed";

export const getAllTypeFeed = async () => {
  const data = await http.get(BASE_URL);
  return data.data;
};

export const getOneTypeFeed = async (id) => {
  const data = await http.get(`${BASE_URL}/${id}`);
  return data.data;
};
