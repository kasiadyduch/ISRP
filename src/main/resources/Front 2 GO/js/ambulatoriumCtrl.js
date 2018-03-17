var url ='http://localhost:8080/';


app.controller('ambulatoriumCtrl', function ($scope, $http) {
    $http.get(url + 'badania/all').then(function (response) {
        console.log(response);
        $scope.badania = response.data;

    });
    $http.get(url + 'poradnie/all').then(function (response) {
        console.log(response);
        $scope.poradnie = response.data;

        $scope.changedOption = function (param) {
            console.log(param);
            $scope.SelectedPoradnia = ($scope.por.opis).toString();
            console.log($scope.SelectedPoradnia);
            $http.get(url + 'lekarze/byporadnia?poradnia=' + $scope.SelectedPoradnia).then(function (response) {
                console.log(response);
                $scope.lekarzeByPoradnia = response.data;
            });
        }

    });
    $http.get(url + 'lekarze/all').then(function (response) {
        console.log(response);
        $scope.lekarze = response.data;

    });
    $scope.SearchPesel = function () {
        $scope.SelectedPesel = ($scope.pesel).toString();
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


    $scope.pokazGodziny = function () {
        $scope.SelectedLekarz = $scope.wybrany.nazwisko;
        console.log($scope.SelectedLekarz);
        $http.get(url + 'godzinyprzyjec/bydzien?nazwisko=' + $scope.SelectedLekarz + '&opis=' + $scope.SelectedPoradnia + '&dzien=' + $scope.date.getDay()).then(function (response) {
            console.log("Działam!");
            console.log(response.data);
            console.log($scope.date);
            $scope.godziny = response.data;
        });
    }


    $scope.addNewRezerwacja = function (rezerwacje) {
        $scope.newRezerwacjaLekarz = $scope.wybrany.id_lekarza;
        $scope.newRezerwacjaPacjent = $scope.pacjentByPesel.id_pacjenta;
        $scope.newRezerwacjaData = moment($scope.dzienzKalendarza).format("YYYY-MM-DD");
        $scope.newRezerwacjaGodzina = $scope.godz + ":00"
        $scope.newRezerwacjaPoradnia = $scope.por.id_poradni;

        console.log($scope);
        var data = {
            "id_lekarza": $scope.newRezerwacjaLekarz,
            "id_pacjenta": $scope.newRezerwacjaPacjent,
            "data": $scope.newRezerwacjaData,
            "godzina": $scope.newRezerwacjaGodzina,
            "id_poradni": $scope.newRezerwacjaPoradnia
        }
        $http({
            method: 'POST',
            url: url + 'rezerwacje/add',
            data: data
        }).success(function (response) {
            console.log('Dodano rezerwacje');
            $scope.newRezerwacjaLekarz = '';
            $scope.newRezerwacjaPacjent = '';
            $scope.newRezerwacjaData = '';
            $scope.newRezerwacjaGodzina = '';
            $scope.newRezerwacjaPoradnia = ''

        })
    }


    $scope.sendEmail = function () {
        $http.get(url + 'send?mail=' + $scope.pacjentByPesel.email + "&mess=" + encodeURIComponent("Potwierdzenie przyjęcia zgłoszenia. Pacjent: " + $scope.pacjentByPesel.imie + " " + $scope.pacjentByPesel.nazwisko + " ; Data wizyty: " + $scope.dzienzKalendarza + "; Godzina wizyty: " + $scope.godz +", Twoje zgłoszenie rejestracji wizyty zostało przyjęte do realizacji. W godzinach pracy poradni pracownik rejestracji skontaktuje się z Panią(em) w celu ustalenia ostatecznego terminu. Przypominamy, że przychodnia jest czynna od poniedziałku do piątku w godzinach od 08:00 do 20:00. Dziękujemy za skorzystanie z naszej platformy. ")).then(function () {
            console.log("Wysłano");
        });
        console.log('wysłano');
    }




});