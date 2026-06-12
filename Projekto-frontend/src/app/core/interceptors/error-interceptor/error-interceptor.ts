import { HttpInterceptorFn, HttpErrorResponse } from '@angular/common/http';
import { inject } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { Router } from '@angular/router';

export const errorInterceptor: HttpInterceptorFn = (req, next) => {
  const router = inject(Router);

  return next(req).pipe(
    catchError((error: HttpErrorResponse) => {
      let errorMessage = 'An error occurred';

      if (error.error instanceof ErrorEvent) {
        // Client-side error
        errorMessage = `Client Error: ${error.error.message}`;
      } else {
        // Server-side error
        switch (error.status) {
          case 400:
            errorMessage = 'Bad Request: ' + (error.error?.message || 'Invalid data');
            break;
          case 401:
            errorMessage = 'Unauthorized: Please login';
            router.navigate(['/login']);
            break;
          case 403:
            errorMessage = 'Forbidden: Access denied';
            break;
          case 404:
            errorMessage = 'Not Found: Resource does not exist';
            break;
          case 500:
            errorMessage = 'Server Error: Please try again later';
            break;
          default:
            errorMessage = `Error ${error.status}: ${error.message}`;
        }
      }

      console.error('HTTP Error:', errorMessage, error);
      // You can show a toast/snackbar here
      return throwError(() => new Error(errorMessage));
    })
  );
};