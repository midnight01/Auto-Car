import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Page
import { HomeComponent } from './components/home/home.component';
import { CcComponent } from './components/cc/cc.component';
import { CarloanComponent } from './components/carloan/carloan.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'go', component: HomeComponent},
  {path: 'cc/:id/:brand/:generation', component: CcComponent},
  {path: 'carloan/:id1/:id2/:id3/:id4/:data', component: CarloanComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
