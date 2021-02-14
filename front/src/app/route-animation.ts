import {
  transition,
  trigger,
  query,
  style,
  animate,
  group,
} from '@angular/animations';

export const slideInAnimation =
  trigger('routeAnimations', [
    transition('Home => Auth', [
      query(':enter, :leave',
        style({ position: 'fixed', width: '100%' }),
        { optional: true }),
      group([
        query(':enter', [
          style({ right: '-100%' }),
          animate('0.4s ease-in-out',
            style({ right: '0%' }))
        ], { optional: true }),
        query(':leave', [
          style({ right:   '0%'}),
          animate('0.4s ease-in-out',
            style({ right: '100%' }))
        ], { optional: true }),
      ])
    ]),
    transition('Auth => Profile', [
      query(':enter, :leave',
        style({ position: 'fixed', width: '100%' }),
        { optional: true }),
      group([
        query(':enter', [
          style({ right: '0%', top: '-100%' }),
          animate('0.4s ease-in-out',
            style({ top: '0%' }))
        ], { optional: true }),
        query(':leave', [
          style({ right: '0%', top: '0%'}),
          animate('0.4s ease-in-out',
            style({ top: '100%' }))
        ], { optional: true }),
      ])
    ])
  ]);
