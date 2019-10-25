import { createDecorator } from 'vue-class-component';

export function Freeze() {
  return createDecorator((options, key) => {
    options.created = function() {
      const data: any = (this as any)[key];
      delete (this as any)[key];
      (this as any)[key] = JSON.parse(JSON.stringify(data));
    };
  });
}
