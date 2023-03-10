import { axiosInstance } from '../_base/axiosInstance';

const URL_CHANGE_PASSWORD = '/usuarios/alterar-senha/:token';

export async function changePassword(password, token) {
  const response = await axiosInstance.post(
    URL_CHANGE_PASSWORD.replace(':token', token),
    {
      novaSenha: password,
    }
  );
  return response.data;
}
