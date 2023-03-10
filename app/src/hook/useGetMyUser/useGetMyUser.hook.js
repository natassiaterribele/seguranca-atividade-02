import { getUserData } from '../../api/user/getUserData.api';
import { useToastr } from '../../hook/useToastr/useToastr.hook';

export function useGetMyUser() {
  const showToastr = useToastr();

  async function getUser() {
    try {
      const response = await getUserData();
      return response;
    } catch (error) {
      if (error.response.status === 429) {
        showToastr(error.response.statusText);
      } else {
        showToastr(error.response.data.message);
      }
      return null;
    }
  }

  return { getUser };
}
