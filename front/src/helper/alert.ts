import Swal, { SweetAlertOptions, SweetAlertResult } from 'sweetalert2';

const parent = Swal.mixin({
  heightAuto: false
});

export const errorAlert = (options: SweetAlertOptions): Promise<SweetAlertResult> => {
  return parent.fire({
    type: 'error',
    ...options
  });
};
