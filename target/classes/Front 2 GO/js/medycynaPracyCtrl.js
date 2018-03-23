var url ='http://localhost:8080/';


app.controller('medycynaPracyCtrl', function ($scope, $http) {

    $http.get(url + 'badania/all').then(function (response) {
        console.log(response);
        $scope.badania = response.data;
    });

    $http.get(url + 'zaklady/all').then(function (response) {
        console.log(response);
        $scope.zakład = response.data;

    });

    $scope.SearchPesel = function () {
        $scope.SelectedPesel = ($scope.pesel);
        console.log($scope.SelectedPesel);
        if ($scope.SelectedPesel.length == 11)
            $http.get(url + 'pacjenci/bypesel?pesel=' + $scope.SelectedPesel).then(function (response) {
                $scope.pacjentByPesel = response.data;
                console.log($scope.pacjentByPesel);

            });
    }
        $scope.addNewPacjentModal = function (pacjenci) {
            $scope.newPacjentImie = pacjenci.imie;
            $scope.newPacjentNazwisko = pacjenci.nazwisko;
            $scope.newPacjentPesel = pacjenci.pesel;
            $scope.newPacjentTelefon = pacjenci.nr_telefonu;
            $scope.newPacjentUlica = pacjenci.ulica;
            $scope.newPacjentNrDomu = pacjenci.nr_domu;
            $scope.newPacjentNrLokalu = pacjenci.nr_lokalu;
            $scope.newPacjentKod = pacjenci.kod_pocztowy;
            $scope.newPacjentMiejscowosc = pacjenci.miejscowosc;
            $scope.newPacjentEmail = pacjenci.email;
        }
        $scope.addNewPacjent = function (pacjenci) {
            var data = {
                "imie": $scope.newPacjentImie,
                "nazwisko": $scope.newPacjentNazwisko,
                "pesel": $scope.newPacjentPesel,
                "ulica": $scope.newPacjentUlica,
                "nr_domu": $scope.newPacjentNrDomu,
                "nr_lokalu": $scope.newPacjentNrLokalu,
                "kod_pocztowy": $scope.newPacjentKod,
                "miejscowosc": $scope.newPacjentMiejscowosc,
                "nr_telefonu": $scope.newPacjentTelefon,
                "email": $scope.newPacjentEmail
            }

            $http({
                method: 'POST',
                url: url + 'pacjenci/add',
                data: data

            }).success(function (response) {
                console.log('Pacjent został dodany');
                $scope.newPacjentImie = '',
                    $scope.newPacjentNazwisko = '',
                    $scope.newPacjentPesel = '',
                    $scope.newPacjentTelefon = '',
                    $scope.newPacjentUlica = '',
                    $scope.newPacjentNrDomu = '',
                    $scope.newPacjentNrLokalu = '',
                    $scope.newPacjentKod = '',
                    $scope.newPacjentMiejscowosc = '',
                    $scope.newPacjentEmail = ''
            })
        }

        $scope.wyswietlDzien = function (response) {
            $scope.date = $scope.dzienzKalendarza;
            console.log($scope.date);
        }


        // $scope.pokazGodziny = function () {
        //     $scope.SelectedLekarz = $scope.wybrany.nazwisko;
        //     console.log($scope.SelectedLekarz);
        //     $http.get(url + 'godzinyprzyjec/bydzien?nazwisko=' + $scope.SelectedLekarz + '&opis=' + $scope.SelectedPoradnia + '&dzien=' + $scope.date.getDay()).then(function (response) {
        //         console.log("Działam!");
        //         console.log(response.data);
        //         console.log($scope.date);
        //         $scope.godziny = response.data;
        //     });
        // }
        $scope.sendEmail = function () {
            console.log($scope.pacjentByPesel);
            $http.get(url + 'send?mail=' + $scope.pacjentByPesel.email + "&mess=" + encodeURIComponent("Potwierdzenie zgłoszenia: Pan(i): "+ $scope.pacjentByPesel.imie + " " + $scope.pacjentByPesel.nazwisko + " ; Data wizyty: " + $scope.dzienzKalendarza + "; Godzina wizyty: " + $scope.godzmp +"Twoje zgłoszenie rejestracji wizyty zostało przyjęte do realizacji. W godzinach pracy poradni pracownik rejestracji skontaktuje się z Panią(em) w celu ustalenia ostatecznego terminu. Przypominamy, że przychodnia jest czynna od poniedziałku do piątku w godzinach od 08:00 do 20:00. Dziękujemy za skorzystanie z naszej platformy.")).then(function () {
                console.log("Wysłano");
            });
        }

        $scope.addNewRezerwacjaMP = function () {
            $scope.newRezerwacjaPacjentMP = $scope.pacjentByPesel.id_pacjenta;
            $scope.newRezerwacjaBadanieMP = $scope.badanie.id_badania;
            $scope.newRezerwacjaDataMP = moment($scope.dzienzKalendarza).format("YYYY-MM-DD");

            console.log($scope);
            var data = {
                "id_pacjenta": $scope.newRezerwacjaPacjentMP,
                "id_badania":$scope.newRezerwacjaBadanieMP,
                "data": $scope.newRezerwacjaDataMP
            }
            $http({
                method: 'POST',
                url: url + 'rezerwacjemp/add',
                data: data
            }).success(function (response) {
                console.log('Dodano rezerwacje');
                $scope.newRezerwacjaPacjentMP = '';
                $scope.newRezerwacjaBadanieMP = '';
                $scope.newRezerwacjaDataMP = '';


            })
        }
})