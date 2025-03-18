package se.linerotech.module202.lecture

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MainCountryDTO(
    @Json(name = "countries")
    val countries: List<Country> = listOf()
) {
    @JsonClass(generateAdapter = true)
    data class Country(
        @Json(name = "name")
        val name: String = "",
        @Json(name = "official_name")
        val officialName: String = "",
        @Json(name = "topLevelDomain")
        val topLevelDomain: List<String> = listOf(),
        @Json(name = "alpha2Code")
        val alpha2Code: String = "",
        @Json(name = "alpha3Code")
        val alpha3Code: String = "",
        @Json(name = "cioc")
        val cioc: String = "",
        @Json(name = "numericCode")
        val numericCode: String = "",
        @Json(name = "callingCode")
        val callingCode: String = "",
        @Json(name = "capital")
        val capital: String = "",
        @Json(name = "altSpellings")
        val altSpellings: List<String> = listOf(),
        @Json(name = "region")
        val region: String = "",
        @Json(name = "subregion")
        val subregion: String = "",
        @Json(name = "population")
        val population: Int = 0,
        @Json(name = "latLng")
        val latLng: LatLng = LatLng(),
        @Json(name = "demonyms")
        val demonyms: Demonyms = Demonyms(),
        @Json(name = "area")
        val area: Double = 0.0,
        @Json(name = "gini")
        val gini: Gini = Gini(),
        @Json(name = "timezones")
        val timezones: List<String> = listOf(),
        @Json(name = "borders")
        val borders: List<String> = listOf(),
        @Json(name = "nativeNames")
        val nativeNames: NativeNames = NativeNames(),
        @Json(name = "currencies")
        val currencies: Currencies = Currencies(),
        @Json(name = "languages")
        val languages: Languages = Languages(),
        @Json(name = "translations")
        val translations: Translations = Translations(),
        @Json(name = "flag")
        val flag: Flag = Flag(),
        @Json(name = "regionalBlocs")
        val regionalBlocs: List<RegionalBloc> = listOf()
    ) {
        @JsonClass(generateAdapter = true)
        data class LatLng(
            @Json(name = "country")
            val country: List<Double> = listOf(),
            @Json(name = "capital")
            val capital: List<Double> = listOf()
        )

        @JsonClass(generateAdapter = true)
        data class Demonyms(
            @Json(name = "eng")
            val eng: Eng = Eng(),
            @Json(name = "fra")
            val fra: Fra = Fra()
        ) {
            @JsonClass(generateAdapter = true)
            data class Eng(
                @Json(name = "f")
                val f: String = "",
                @Json(name = "m")
                val m: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Fra(
                @Json(name = "f")
                val f: String = "",
                @Json(name = "m")
                val m: String = ""
            )
        }

        @JsonClass(generateAdapter = true)
        data class Gini(
            @Json(name = "2014")
            val x2014: Double = 0.0,
            @Json(name = "2013")
            val x2013: Double = 0.0,
            @Json(name = "2018")
            val x2018: Double = 0.0,
            @Json(name = "2017")
            val x2017: Double = 0.0,
            @Json(name = "1998")
            val x1998: Double = 0.0,
            @Json(name = "2011")
            val x2011: Double = 0.0,
            @Json(name = "2015")
            val x2015: Double = 0.0,
            @Json(name = "2005")
            val x2005: Double = 0.0,
            @Json(name = "2019")
            val x2019: Double = 0.0,
            @Json(name = "2016")
            val x2016: Double = 0.0,
            @Json(name = "2006")
            val x2006: Double = 0.0,
            @Json(name = "1992")
            val x1992: Double = 0.0,
            @Json(name = "2009")
            val x2009: Double = 0.0,
            @Json(name = "1999")
            val x1999: Double = 0.0,
            @Json(name = "2012")
            val x2012: Double = 0.0,
            @Json(name = "2003")
            val x2003: Double = 0.0,
            @Json(name = "2008")
            val x2008: Double = 0.0,
            @Json(name = "2010")
            val x2010: Double = 0.0,
            @Json(name = "2004")
            val x2004: Double = 0.0
        )

        @JsonClass(generateAdapter = true)
        data class NativeNames(
            @Json(name = "prs")
            val prs: Prs = Prs(),
            @Json(name = "pus")
            val pus: Pus = Pus(),
            @Json(name = "tuk")
            val tuk: Tuk = Tuk(),
            @Json(name = "ara")
            val ara: Ara = Ara(),
            @Json(name = "eng")
            val eng: Eng = Eng(),
            @Json(name = "fra")
            val fra: Fra = Fra(),
            @Json(name = "run")
            val run: Run = Run(),
            @Json(name = "spa")
            val spa: Spa = Spa(),
            @Json(name = "srp")
            val srp: Srp = Srp(),
            @Json(name = "dzo")
            val dzo: Dzo = Dzo(),
            @Json(name = "bos")
            val bos: Bos = Bos(),
            @Json(name = "hrv")
            val hrv: Hrv = Hrv(),
            @Json(name = "msa")
            val msa: Msa = Msa(),
            @Json(name = "urd")
            val urd: Urd = Urd(),
            @Json(name = "swa")
            val swa: Swa = Swa(),
            @Json(name = "som")
            val som: Som = Som(),
            @Json(name = "nor")
            val nor: Nor = Nor(),
            @Json(name = "aze")
            val aze: Aze = Aze(),
            @Json(name = "rus")
            val rus: Rus = Rus(),
            @Json(name = "rar")
            val rar: Rar = Rar(),
            @Json(name = "aym")
            val aym: Aym = Aym(),
            @Json(name = "que")
            val que: Que = Que(),
            @Json(name = "cal")
            val cal: Cal = Cal(),
            @Json(name = "cha")
            val cha: Cha = Cha(),
            @Json(name = "por")
            val por: Por = Por(),
            @Json(name = "kon")
            val kon: Kon = Kon(),
            @Json(name = "lin")
            val lin: Lin = Lin(),
            @Json(name = "tur")
            val tur: Tur = Tur(),
            @Json(name = "nld")
            val nld: Nld = Nld(),
            @Json(name = "pap")
            val pap: Pap = Pap(),
            @Json(name = "zho")
            val zho: Zho = Zho(),
            @Json(name = "swe")
            val swe: Swe = Swe(),
            @Json(name = "sqi")
            val sqi: Sqi = Sqi(),
            @Json(name = "deu")
            val deu: Deu = Deu(),
            @Json(name = "ltz")
            val ltz: Ltz = Ltz(),
            @Json(name = "tir")
            val tir: Tir = Tir(),
            @Json(name = "mon")
            val mon: Mon = Mon(),
            @Json(name = "vie")
            val vie: Vie = Vie(),
            @Json(name = "pau")
            val pau: Pau = Pau(),
            @Json(name = "nrf")
            val nrf: Nrf = Nrf(),
            @Json(name = "heb")
            val heb: Heb = Heb(),
            @Json(name = "bul")
            val bul: Bul = Bul(),
            @Json(name = "ita")
            val ita: Ita = Ita(),
            @Json(name = "tam")
            val tam: Tam = Tam(),
            @Json(name = "ron")
            val ron: Ron = Ron(),
            @Json(name = "hmo")
            val hmo: Hmo = Hmo(),
            @Json(name = "tpi")
            val tpi: Tpi = Tpi(),
            @Json(name = "bjz")
            val bjz: Bjz = Bjz(),
            @Json(name = "zdj")
            val zdj: Zdj = Zdj(),
            @Json(name = "dan")
            val dan: Dan = Dan(),
            @Json(name = "fao")
            val fao: Fao = Fao(),
            @Json(name = "hin")
            val hin: Hin = Hin(),
            @Json(name = "ind")
            val ind: Ind = Ind(),
            @Json(name = "bar")
            val bar: Bar = Bar(),
            @Json(name = "tgk")
            val tgk: Tgk = Tgk(),
            @Json(name = "lua")
            val lua: Lua = Lua(),
            @Json(name = "lit")
            val lit: Lit = Lit(),
            @Json(name = "mri")
            val mri: Mri = Mri(),
            @Json(name = "nzs")
            val nzs: Nzs = Nzs(),
            @Json(name = "pih")
            val pih: Pih = Pih(),
            @Json(name = "uzb")
            val uzb: Uzb = Uzb(),
            @Json(name = "fin")
            val fin: Fin = Fin(),
            @Json(name = "isl")
            val isl: Isl = Isl(),
            @Json(name = "mkd")
            val mkd: Mkd = Mkd(),
            @Json(name = "ell")
            val ell: Ell = Ell(),
            @Json(name = "grn")
            val grn: Grn = Grn(),
            @Json(name = "niu")
            val niu: Niu = Niu(),
            @Json(name = "lav")
            val lav: Lav = Lav(),
            @Json(name = "smo")
            val smo: Smo = Smo(),
            @Json(name = "tkl")
            val tkl: Tkl = Tkl(),
            @Json(name = "jpn")
            val jpn: Jpn = Jpn(),
            @Json(name = "sag")
            val sag: Sag = Sag(),
            @Json(name = "arc")
            val arc: Arc = Arc(),
            @Json(name = "ckb")
            val ckb: Ckb = Ckb(),
            @Json(name = "glv")
            val glv: Glv = Glv(),
            @Json(name = "mya")
            val mya: Mya = Mya(),
            @Json(name = "cnr")
            val cnr: Cnr = Cnr(),
            @Json(name = "nau")
            val nau: Nau = Nau(),
            @Json(name = "bis")
            val bis: Bis = Bis(),
            @Json(name = "bwg")
            val bwg: Bwg = Bwg(),
            @Json(name = "kck")
            val kck: Kck = Kck(),
            @Json(name = "khi")
            val khi: Khi = Khi(),
            @Json(name = "ndc")
            val ndc: Ndc = Ndc(),
            @Json(name = "nde")
            val nde: Nde = Nde(),
            @Json(name = "nya")
            val nya: Nya = Nya(),
            @Json(name = "sna")
            val sna: Sna = Sna(),
            @Json(name = "sot")
            val sot: Sot = Sot(),
            @Json(name = "toi")
            val toi: Toi = Toi(),
            @Json(name = "tsn")
            val tsn: Tsn = Tsn(),
            @Json(name = "tso")
            val tso: Tso = Tso(),
            @Json(name = "ven")
            val ven: Ven = Ven(),
            @Json(name = "xho")
            val xho: Xho = Xho(),
            @Json(name = "zib")
            val zib: Zib = Zib(),
            @Json(name = "fil")
            val fil: Fil = Fil(),
            @Json(name = "slk")
            val slk: Slk = Slk(),
            @Json(name = "ssw")
            val ssw: Ssw = Ssw(),
            @Json(name = "kin")
            val kin: Kin = Kin(),
            @Json(name = "gle")
            val gle: Gle = Gle(),
            @Json(name = "fas")
            val fas: Fas = Fas(),
            @Json(name = "slv")
            val slv: Slv = Slv(),
            @Json(name = "gsw")
            val gsw: Gsw = Gsw(),
            @Json(name = "roh")
            val roh: Roh = Roh(),
            @Json(name = "ukr")
            val ukr: Ukr = Ukr(),
            @Json(name = "ces")
            val ces: Ces = Ces(),
            @Json(name = "lao")
            val lao: Lao = Lao(),
            @Json(name = "amh")
            val amh: Amh = Amh(),
            @Json(name = "ben")
            val ben: Ben = Ben(),
            @Json(name = "bel")
            val bel: Bel = Bel(),
            @Json(name = "ber")
            val ber: Ber = Ber(),
            @Json(name = "est")
            val est: Est = Est(),
            @Json(name = "sin")
            val sin: Sin = Sin(),
            @Json(name = "pol")
            val pol: Pol = Pol(),
            @Json(name = "mlg")
            val mlg: Mlg = Mlg(),
            @Json(name = "cat")
            val cat: Cat = Cat(),
            @Json(name = "afr")
            val afr: Afr = Afr(),
            @Json(name = "her")
            val her: Her = Her(),
            @Json(name = "hgm")
            val hgm: Hgm = Hgm(),
            @Json(name = "kwn")
            val kwn: Kwn = Kwn(),
            @Json(name = "loz")
            val loz: Loz = Loz(),
            @Json(name = "ndo")
            val ndo: Ndo = Ndo(),
            @Json(name = "crs")
            val crs: Crs = Crs(),
            @Json(name = "hat")
            val hat: Hat = Hat(),
            @Json(name = "gil")
            val gil: Gil = Gil(),
            @Json(name = "mah")
            val mah: Mah = Mah(),
            @Json(name = "hun")
            val hun: Hun = Hun(),
            @Json(name = "nbl")
            val nbl: Nbl = Nbl(),
            @Json(name = "nso")
            val nso: Nso = Nso(),
            @Json(name = "zul")
            val zul: Zul = Zul(),
            @Json(name = "kal")
            val kal: Kal = Kal(),
            @Json(name = "tvl")
            val tvl: Tvl = Tvl(),
            @Json(name = "kor")
            val kor: Kor = Kor(),
            @Json(name = "pov")
            val pov: Pov = Pov(),
            @Json(name = "lat")
            val lat: Lat = Lat(),
            @Json(name = "nno")
            val nno: Nno = Nno(),
            @Json(name = "nob")
            val nob: Nob = Nob(),
            @Json(name = "smi")
            val smi: Smi = Smi(),
            @Json(name = "jam")
            val jam: Jam = Jam(),
            @Json(name = "khm")
            val khm: Khm = Khm(),
            @Json(name = "mfe")
            val mfe: Mfe = Mfe(),
            @Json(name = "mey")
            val mey: Mey = Mey(),
            @Json(name = "kir")
            val kir: Kir = Kir(),
            @Json(name = "tet")
            val tet: Tet = Tet(),
            @Json(name = "mlt")
            val mlt: Mlt = Mlt(),
            @Json(name = "kaz")
            val kaz: Kaz = Kaz(),
            @Json(name = "ton")
            val ton: Ton = Ton(),
            @Json(name = "tha")
            val tha: Tha = Tha(),
            @Json(name = "kat")
            val kat: Kat = Kat(),
            @Json(name = "fij")
            val fij: Fij = Fij(),
            @Json(name = "hif")
            val hif: Hif = Hif(),
            @Json(name = "hye")
            val hye: Hye = Hye(),
            @Json(name = "nfr")
            val nfr: Nfr = Nfr(),
            @Json(name = "nep")
            val nep: Nep = Nep(),
            @Json(name = "div")
            val div: Div = Div()
        ) {
            @JsonClass(generateAdapter = true)
            data class Prs(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Pus(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Tuk(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ara(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Eng(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Fra(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Run(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Spa(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Srp(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Dzo(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Bos(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Hrv(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Msa(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Urd(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Swa(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Som(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Nor(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Aze(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Rus(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Rar(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Aym(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Que(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Cal(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Cha(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Por(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Kon(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Lin(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Tur(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Nld(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Pap(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Zho(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Swe(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Sqi(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Deu(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ltz(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Tir(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Mon(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Vie(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Pau(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Nrf(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Heb(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Bul(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ita(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Tam(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ron(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Hmo(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Tpi(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Bjz(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Zdj(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Dan(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Fao(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Hin(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ind(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Bar(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Tgk(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Lua(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Lit(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Mri(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Nzs(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Pih(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Uzb(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Fin(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Isl(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Mkd(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ell(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Grn(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Niu(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Lav(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Smo(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Tkl(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Jpn(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Sag(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Arc(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ckb(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Glv(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Mya(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Cnr(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Nau(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Bis(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Bwg(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Kck(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Khi(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ndc(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Nde(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Nya(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Sna(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Sot(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Toi(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Tsn(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Tso(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ven(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Xho(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Zib(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Fil(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Slk(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ssw(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Kin(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Gle(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Fas(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Slv(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Gsw(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Roh(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ukr(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ces(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Lao(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Amh(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ben(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Bel(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ber(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Est(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Sin(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Pol(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Mlg(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Cat(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Afr(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Her(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Hgm(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Kwn(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Loz(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ndo(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Crs(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Hat(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Gil(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Mah(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Hun(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Nbl(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Nso(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Zul(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Kal(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Tvl(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Kor(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Pov(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Lat(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Nno(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Nob(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Smi(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Jam(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Khm(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Mfe(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Mey(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Kir(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Tet(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Mlt(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Kaz(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Ton(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Tha(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Kat(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Fij(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Hif(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Hye(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Nfr(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Nep(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Div(
                @Json(name = "official")
                val official: String = "",
                @Json(name = "common")
                val common: String = ""
            )
        }

        @JsonClass(generateAdapter = true)
        data class Currencies(
            @Json(name = "AFN")
            val aFN: AFN = AFN(),
            @Json(name = "SDG")
            val sDG: SDG = SDG(),
            @Json(name = "BIF")
            val bIF: BIF = BIF(),
            @Json(name = "MXN")
            val mXN: MXN = MXN(),
            @Json(name = "CUC")
            val cUC: CUC = CUC(),
            @Json(name = "CUP")
            val cUP: CUP = CUP(),
            @Json(name = "RSD")
            val rSD: RSD = RSD(),
            @Json(name = "EUR")
            val eUR: EUR = EUR(),
            @Json(name = "BTN")
            val bTN: BTN = BTN(),
            @Json(name = "INR")
            val iNR: INR = INR(),
            @Json(name = "GYD")
            val gYD: GYD = GYD(),
            @Json(name = "SHP")
            val sHP: SHP = SHP(),
            @Json(name = "BAM")
            val bAM: BAM = BAM(),
            @Json(name = "BND")
            val bND: BND = BND(),
            @Json(name = "SGD")
            val sGD: SGD = SGD(),
            @Json(name = "PKR")
            val pKR: PKR = PKR(),
            @Json(name = "KES")
            val kES: KES = KES(),
            @Json(name = "USD")
            val uSD: USD = USD(),
            @Json(name = "SOS")
            val sOS: SOS = SOS(),
            @Json(name = "NOK")
            val nOK: NOK = NOK(),
            @Json(name = "SLL")
            val sLL: SLL = SLL(),
            @Json(name = "XPF")
            val xPF: XPF = XPF(),
            @Json(name = "AZN")
            val aZN: AZN = AZN(),
            @Json(name = "CKD")
            val cKD: CKD = CKD(),
            @Json(name = "NZD")
            val nZD: NZD = NZD(),
            @Json(name = "PEN")
            val pEN: PEN = PEN(),
            @Json(name = "AOA")
            val aOA: AOA = AOA(),
            @Json(name = "XAF")
            val xAF: XAF = XAF(),
            @Json(name = "SSP")
            val sSP: SSP = SSP(),
            @Json(name = "TRY")
            val tRY: TRY = TRY(),
            @Json(name = "XCD")
            val xCD: XCD = XCD(),
            @Json(name = "AWG")
            val aWG: AWG = AWG(),
            @Json(name = "TWD")
            val tWD: TWD = TWD(),
            @Json(name = "SEK")
            val sEK: SEK = SEK(),
            @Json(name = "LRD")
            val lRD: LRD = LRD(),
            @Json(name = "VES")
            val vES: VES = VES(),
            @Json(name = "BMD")
            val bMD: BMD = BMD(),
            @Json(name = "ALL")
            val aLL: ALL = ALL(),
            @Json(name = "HKD")
            val hKD: HKD = HKD(),
            @Json(name = "ERN")
            val eRN: ERN = ERN(),
            @Json(name = "COP")
            val cOP: COP = COP(),
            @Json(name = "MNT")
            val mNT: MNT = MNT(),
            @Json(name = "YER")
            val yER: YER = YER(),
            @Json(name = "LBP")
            val lBP: LBP = LBP(),
            @Json(name = "VND")
            val vND: VND = VND(),
            @Json(name = "GBP")
            val gBP: GBP = GBP(),
            @Json(name = "JEP")
            val jEP: JEP = JEP(),
            @Json(name = "TTD")
            val tTD: TTD = TTD(),
            @Json(name = "ILS")
            val iLS: ILS = ILS(),
            @Json(name = "BGN")
            val bGN: BGN = BGN(),
            @Json(name = "GIP")
            val gIP: GIP = GIP(),
            @Json(name = "ANG")
            val aNG: ANG = ANG(),
            @Json(name = "SAR")
            val sAR: SAR = SAR(),
            @Json(name = "GHS")
            val gHS: GHS = GHS(),
            @Json(name = "MDL")
            val mDL: MDL = MDL(),
            @Json(name = "AAD")
            val aAD: AAD = AAD(),
            @Json(name = "PGK")
            val pGK: PGK = PGK(),
            @Json(name = "BZD")
            val bZD: BZD = BZD(),
            @Json(name = "KMF")
            val kMF: KMF = KMF(),
            @Json(name = "XOF")
            val xOF: XOF = XOF(),
            @Json(name = "DKK")
            val dKK: DKK = DKK(),
            @Json(name = "FOK")
            val fOK: FOK = FOK(),
            @Json(name = "GNF")
            val gNF: GNF = GNF(),
            @Json(name = "TND")
            val tND: TND = TND(),
            @Json(name = "IDR")
            val iDR: IDR = IDR(),
            @Json(name = "TJS")
            val tJS: TJS = TJS(),
            @Json(name = "CDF")
            val cDF: CDF = CDF(),
            @Json(name = "RON")
            val rON: RON = RON(),
            @Json(name = "QAR")
            val qAR: QAR = QAR(),
            @Json(name = "CNY")
            val cNY: CNY = CNY(),
            @Json(name = "AUD")
            val aUD: AUD = AUD(),
            @Json(name = "MRU")
            val mRU: MRU = MRU(),
            @Json(name = "UZS")
            val uZS: UZS = UZS(),
            @Json(name = "ISK")
            val iSK: ISK = ISK(),
            @Json(name = "OMR")
            val oMR: OMR = OMR(),
            @Json(name = "MKD")
            val mKD: MKD = MKD(),
            @Json(name = "CHF")
            val cHF: CHF = CHF(),
            @Json(name = "PYG")
            val pYG: PYG = PYG(),
            @Json(name = "BHD")
            val bHD: BHD = BHD(),
            @Json(name = "JPY")
            val jPY: JPY = JPY(),
            @Json(name = "IQD")
            val iQD: IQD = IQD(),
            @Json(name = "IMP")
            val iMP: IMP = IMP(),
            @Json(name = "MMK")
            val mMK: MMK = MMK(),
            @Json(name = "VUV")
            val vUV: VUV = VUV(),
            @Json(name = "ZWL")
            val zWL: ZWL = ZWL(),
            @Json(name = "PHP")
            val pHP: PHP = PHP(),
            @Json(name = "SZL")
            val sZL: SZL = SZL(),
            @Json(name = "ZAR")
            val zAR: ZAR = ZAR(),
            @Json(name = "RWF")
            val rWF: RWF = RWF(),
            @Json(name = "UGX")
            val uGX: UGX = UGX(),
            @Json(name = "IRR")
            val iRR: IRR = IRR(),
            @Json(name = "UYU")
            val uYU: UYU = UYU(),
            @Json(name = "SRD")
            val sRD: SRD = SRD(),
            @Json(name = "UAH")
            val uAH: UAH = UAH(),
            @Json(name = "CZK")
            val cZK: CZK = CZK(),
            @Json(name = "HNL")
            val hNL: HNL = HNL(),
            @Json(name = "WST")
            val wST: WST = WST(),
            @Json(name = "LAK")
            val lAK: LAK = LAK(),
            @Json(name = "CVE")
            val cVE: CVE = CVE(),
            @Json(name = "ETB")
            val eTB: ETB = ETB(),
            @Json(name = "BDT")
            val bDT: BDT = BDT(),
            @Json(name = "BYN")
            val bYN: BYN = BYN(),
            @Json(name = "HRK")
            val hRK: HRK = HRK(),
            @Json(name = "KWD")
            val kWD: KWD = KWD(),
            @Json(name = "MAD")
            val mAD: MAD = MAD(),
            @Json(name = "RUB")
            val rUB: RUB = RUB(),
            @Json(name = "LKR")
            val lKR: LKR = LKR(),
            @Json(name = "PLN")
            val pLN: PLN = PLN(),
            @Json(name = "MGA")
            val mGA: MGA = MGA(),
            @Json(name = "CRC")
            val cRC: CRC = CRC(),
            @Json(name = "MOP")
            val mOP: MOP = MOP(),
            @Json(name = "NAD")
            val nAD: NAD = NAD(),
            @Json(name = "SCR")
            val sCR: SCR = SCR(),
            @Json(name = "PAB")
            val pAB: PAB = PAB(),
            @Json(name = "HTG")
            val hTG: HTG = HTG(),
            @Json(name = "ARS")
            val aRS: ARS = ARS(),
            @Json(name = "MWK")
            val mWK: MWK = MWK(),
            @Json(name = "KID")
            val kID: KID = KID(),
            @Json(name = "SYP")
            val sYP: SYP = SYP(),
            @Json(name = "HUF")
            val hUF: HUF = HUF(),
            @Json(name = "KYD")
            val kYD: KYD = KYD(),
            @Json(name = "BOB")
            val bOB: BOB = BOB(),
            @Json(name = "DJF")
            val dJF: DJF = DJF(),
            @Json(name = "NGN")
            val nGN: NGN = NGN(),
            @Json(name = "STN")
            val sTN: STN = STN(),
            @Json(name = "NIO")
            val nIO: NIO = NIO(),
            @Json(name = "BSD")
            val bSD: BSD = BSD(),
            @Json(name = "CLP")
            val cLP: CLP = CLP(),
            @Json(name = "MYR")
            val mYR: MYR = MYR(),
            @Json(name = "TVD")
            val tVD: TVD = TVD(),
            @Json(name = "SBD")
            val sBD: SBD = SBD(),
            @Json(name = "TZS")
            val tZS: TZS = TZS(),
            @Json(name = "KPW")
            val kPW: KPW = KPW(),
            @Json(name = "EGP")
            val eGP: EGP = EGP(),
            @Json(name = "JOD")
            val jOD: JOD = JOD(),
            @Json(name = "JMD")
            val jMD: JMD = JMD(),
            @Json(name = "KHR")
            val kHR: KHR = KHR(),
            @Json(name = "MUR")
            val mUR: MUR = MUR(),
            @Json(name = "GMD")
            val gMD: GMD = GMD(),
            @Json(name = "LSL")
            val lSL: LSL = LSL(),
            @Json(name = "DZD")
            val dZD: DZD = DZD(),
            @Json(name = "AED")
            val aED: AED = AED(),
            @Json(name = "MZN")
            val mZN: MZN = MZN(),
            @Json(name = "ZMW")
            val zMW: ZMW = ZMW(),
            @Json(name = "GTQ")
            val gTQ: GTQ = GTQ(),
            @Json(name = "KRW")
            val kRW: KRW = KRW(),
            @Json(name = "KGS")
            val kGS: KGS = KGS(),
            @Json(name = "FKP")
            val fKP: FKP = FKP(),
            @Json(name = "KZT")
            val kZT: KZT = KZT(),
            @Json(name = "BWP")
            val bWP: BWP = BWP(),
            @Json(name = "BBD")
            val bBD: BBD = BBD(),
            @Json(name = "TOP")
            val tOP: TOP = TOP(),
            @Json(name = "THB")
            val tHB: THB = THB(),
            @Json(name = "CAD")
            val cAD: CAD = CAD(),
            @Json(name = "GEL")
            val gEL: GEL = GEL(),
            @Json(name = "FJD")
            val fJD: FJD = FJD(),
            @Json(name = "AMD")
            val aMD: AMD = AMD(),
            @Json(name = "DOP")
            val dOP: DOP = DOP(),
            @Json(name = "GGP")
            val gGP: GGP = GGP(),
            @Json(name = "TMT")
            val tMT: TMT = TMT(),
            @Json(name = "NPR")
            val nPR: NPR = NPR(),
            @Json(name = "MVR")
            val mVR: MVR = MVR(),
            @Json(name = "LYD")
            val lYD: LYD = LYD(),
            @Json(name = "BRL")
            val bRL: BRL = BRL()
        ) {
            @JsonClass(generateAdapter = true)
            data class AFN(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class SDG(
                @Json(name = "name")
                val name: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BIF(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class MXN(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class CUC(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class CUP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class RSD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class EUR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BTN(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class INR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class GYD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class SHP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BAM(
                @Json(name = "name")
                val name: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BND(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class SGD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class PKR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class KES(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class USD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class SOS(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class NOK(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class SLL(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class XPF(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class AZN(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class CKD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class NZD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class PEN(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class AOA(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class XAF(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class SSP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class TRY(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class XCD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class AWG(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class TWD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class SEK(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class LRD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class VES(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BMD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class ALL(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class HKD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class ERN(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class COP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class MNT(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class YER(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class LBP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class VND(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class GBP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class JEP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class TTD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class ILS(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BGN(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class GIP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class ANG(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class SAR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class GHS(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class MDL(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class AAD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class PGK(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BZD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class KMF(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class XOF(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class DKK(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class FOK(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class GNF(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class TND(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class IDR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class TJS(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class CDF(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class RON(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class QAR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class CNY(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class AUD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class MRU(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class UZS(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class ISK(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class OMR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class MKD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class CHF(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class PYG(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BHD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class JPY(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class IQD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class IMP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class MMK(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class VUV(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class ZWL(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class PHP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class SZL(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class ZAR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class RWF(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class UGX(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class IRR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class UYU(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class SRD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class UAH(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class CZK(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class HNL(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class WST(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class LAK(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class CVE(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class ETB(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BDT(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BYN(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class HRK(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class KWD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class MAD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class RUB(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class LKR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class PLN(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class MGA(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class CRC(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class MOP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class NAD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class SCR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class PAB(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class HTG(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class ARS(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class MWK(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class KID(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class SYP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class HUF(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class KYD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BOB(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class DJF(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class NGN(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class STN(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class NIO(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BSD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class CLP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class MYR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class TVD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class SBD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class TZS(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class KPW(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class EGP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class JOD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class JMD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class KHR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class MUR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class GMD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class LSL(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class DZD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class AED(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class MZN(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class ZMW(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class GTQ(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class KRW(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class KGS(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class FKP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class KZT(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BWP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BBD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class TOP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class THB(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class CAD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class GEL(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class FJD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class AMD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class DOP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class GGP(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class TMT(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class NPR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class MVR(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class LYD(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class BRL(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "symbol")
                val symbol: String = ""
            )
        }

        @JsonClass(generateAdapter = true)
        data class Languages(
            @Json(name = "prs")
            val prs: String = "",
            @Json(name = "pus")
            val pus: String = "",
            @Json(name = "tuk")
            val tuk: String = "",
            @Json(name = "ara")
            val ara: String = "",
            @Json(name = "eng")
            val eng: String = "",
            @Json(name = "fra")
            val fra: String = "",
            @Json(name = "run")
            val run: String = "",
            @Json(name = "spa")
            val spa: String = "",
            @Json(name = "srp")
            val srp: String = "",
            @Json(name = "dzo")
            val dzo: String = "",
            @Json(name = "bos")
            val bos: String = "",
            @Json(name = "hrv")
            val hrv: String = "",
            @Json(name = "msa")
            val msa: String = "",
            @Json(name = "urd")
            val urd: String = "",
            @Json(name = "swa")
            val swa: String = "",
            @Json(name = "som")
            val som: String = "",
            @Json(name = "nor")
            val nor: String = "",
            @Json(name = "aze")
            val aze: String = "",
            @Json(name = "rus")
            val rus: String = "",
            @Json(name = "rar")
            val rar: String = "",
            @Json(name = "aym")
            val aym: String = "",
            @Json(name = "que")
            val que: String = "",
            @Json(name = "cal")
            val cal: String = "",
            @Json(name = "cha")
            val cha: String = "",
            @Json(name = "por")
            val por: String = "",
            @Json(name = "kon")
            val kon: String = "",
            @Json(name = "lin")
            val lin: String = "",
            @Json(name = "tur")
            val tur: String = "",
            @Json(name = "nld")
            val nld: String = "",
            @Json(name = "pap")
            val pap: String = "",
            @Json(name = "zho")
            val zho: String = "",
            @Json(name = "swe")
            val swe: String = "",
            @Json(name = "sqi")
            val sqi: String = "",
            @Json(name = "deu")
            val deu: String = "",
            @Json(name = "ltz")
            val ltz: String = "",
            @Json(name = "tir")
            val tir: String = "",
            @Json(name = "mon")
            val mon: String = "",
            @Json(name = "vie")
            val vie: String = "",
            @Json(name = "pau")
            val pau: String = "",
            @Json(name = "nrf")
            val nrf: String = "",
            @Json(name = "heb")
            val heb: String = "",
            @Json(name = "bul")
            val bul: String = "",
            @Json(name = "ita")
            val ita: String = "",
            @Json(name = "tam")
            val tam: String = "",
            @Json(name = "ron")
            val ron: String = "",
            @Json(name = "hmo")
            val hmo: String = "",
            @Json(name = "tpi")
            val tpi: String = "",
            @Json(name = "bjz")
            val bjz: String = "",
            @Json(name = "zdj")
            val zdj: String = "",
            @Json(name = "dan")
            val dan: String = "",
            @Json(name = "fao")
            val fao: String = "",
            @Json(name = "hin")
            val hin: String = "",
            @Json(name = "ind")
            val ind: String = "",
            @Json(name = "bar")
            val bar: String = "",
            @Json(name = "tgk")
            val tgk: String = "",
            @Json(name = "lua")
            val lua: String = "",
            @Json(name = "lit")
            val lit: String = "",
            @Json(name = "mri")
            val mri: String = "",
            @Json(name = "nzs")
            val nzs: String = "",
            @Json(name = "pih")
            val pih: String = "",
            @Json(name = "uzb")
            val uzb: String = "",
            @Json(name = "fin")
            val fin: String = "",
            @Json(name = "isl")
            val isl: String = "",
            @Json(name = "mkd")
            val mkd: String = "",
            @Json(name = "ell")
            val ell: String = "",
            @Json(name = "grn")
            val grn: String = "",
            @Json(name = "niu")
            val niu: String = "",
            @Json(name = "lav")
            val lav: String = "",
            @Json(name = "smo")
            val smo: String = "",
            @Json(name = "tkl")
            val tkl: String = "",
            @Json(name = "jpn")
            val jpn: String = "",
            @Json(name = "sag")
            val sag: String = "",
            @Json(name = "arc")
            val arc: String = "",
            @Json(name = "ckb")
            val ckb: String = "",
            @Json(name = "glv")
            val glv: String = "",
            @Json(name = "mya")
            val mya: String = "",
            @Json(name = "cnr")
            val cnr: String = "",
            @Json(name = "nau")
            val nau: String = "",
            @Json(name = "bis")
            val bis: String = "",
            @Json(name = "bwg")
            val bwg: String = "",
            @Json(name = "kck")
            val kck: String = "",
            @Json(name = "khi")
            val khi: String = "",
            @Json(name = "ndc")
            val ndc: String = "",
            @Json(name = "nde")
            val nde: String = "",
            @Json(name = "nya")
            val nya: String = "",
            @Json(name = "sna")
            val sna: String = "",
            @Json(name = "sot")
            val sot: String = "",
            @Json(name = "toi")
            val toi: String = "",
            @Json(name = "tsn")
            val tsn: String = "",
            @Json(name = "tso")
            val tso: String = "",
            @Json(name = "ven")
            val ven: String = "",
            @Json(name = "xho")
            val xho: String = "",
            @Json(name = "zib")
            val zib: String = "",
            @Json(name = "fil")
            val fil: String = "",
            @Json(name = "slk")
            val slk: String = "",
            @Json(name = "ssw")
            val ssw: String = "",
            @Json(name = "kin")
            val kin: String = "",
            @Json(name = "gle")
            val gle: String = "",
            @Json(name = "fas")
            val fas: String = "",
            @Json(name = "slv")
            val slv: String = "",
            @Json(name = "gsw")
            val gsw: String = "",
            @Json(name = "roh")
            val roh: String = "",
            @Json(name = "ukr")
            val ukr: String = "",
            @Json(name = "ces")
            val ces: String = "",
            @Json(name = "lao")
            val lao: String = "",
            @Json(name = "amh")
            val amh: String = "",
            @Json(name = "ben")
            val ben: String = "",
            @Json(name = "bel")
            val bel: String = "",
            @Json(name = "ber")
            val ber: String = "",
            @Json(name = "est")
            val est: String = "",
            @Json(name = "sin")
            val sin: String = "",
            @Json(name = "pol")
            val pol: String = "",
            @Json(name = "mlg")
            val mlg: String = "",
            @Json(name = "cat")
            val cat: String = "",
            @Json(name = "afr")
            val afr: String = "",
            @Json(name = "her")
            val her: String = "",
            @Json(name = "hgm")
            val hgm: String = "",
            @Json(name = "kwn")
            val kwn: String = "",
            @Json(name = "loz")
            val loz: String = "",
            @Json(name = "ndo")
            val ndo: String = "",
            @Json(name = "crs")
            val crs: String = "",
            @Json(name = "hat")
            val hat: String = "",
            @Json(name = "gil")
            val gil: String = "",
            @Json(name = "mah")
            val mah: String = "",
            @Json(name = "hun")
            val hun: String = "",
            @Json(name = "nbl")
            val nbl: String = "",
            @Json(name = "nso")
            val nso: String = "",
            @Json(name = "zul")
            val zul: String = "",
            @Json(name = "kal")
            val kal: String = "",
            @Json(name = "tvl")
            val tvl: String = "",
            @Json(name = "kor")
            val kor: String = "",
            @Json(name = "pov")
            val pov: String = "",
            @Json(name = "lat")
            val lat: String = "",
            @Json(name = "nno")
            val nno: String = "",
            @Json(name = "nob")
            val nob: String = "",
            @Json(name = "smi")
            val smi: String = "",
            @Json(name = "jam")
            val jam: String = "",
            @Json(name = "khm")
            val khm: String = "",
            @Json(name = "mfe")
            val mfe: String = "",
            @Json(name = "mey")
            val mey: String = "",
            @Json(name = "kir")
            val kir: String = "",
            @Json(name = "tet")
            val tet: String = "",
            @Json(name = "mlt")
            val mlt: String = "",
            @Json(name = "kaz")
            val kaz: String = "",
            @Json(name = "ton")
            val ton: String = "",
            @Json(name = "tha")
            val tha: String = "",
            @Json(name = "kat")
            val kat: String = "",
            @Json(name = "fij")
            val fij: String = "",
            @Json(name = "hif")
            val hif: String = "",
            @Json(name = "hye")
            val hye: String = "",
            @Json(name = "nfr")
            val nfr: String = "",
            @Json(name = "nep")
            val nep: String = "",
            @Json(name = "div")
            val div: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Translations(
            @Json(name = "ara")
            val ara: String = "",
            @Json(name = "ces")
            val ces: String = "",
            @Json(name = "cym")
            val cym: String = "",
            @Json(name = "deu")
            val deu: String = "",
            @Json(name = "est")
            val est: String = "",
            @Json(name = "fin")
            val fin: String = "",
            @Json(name = "fra")
            val fra: String = "",
            @Json(name = "hrv")
            val hrv: String = "",
            @Json(name = "hun")
            val hun: String = "",
            @Json(name = "ita")
            val ita: String = "",
            @Json(name = "jpn")
            val jpn: String = "",
            @Json(name = "kor")
            val kor: String = "",
            @Json(name = "nld")
            val nld: String = "",
            @Json(name = "per")
            val per: String = "",
            @Json(name = "pol")
            val pol: String = "",
            @Json(name = "por")
            val por: String = "",
            @Json(name = "rus")
            val rus: String = "",
            @Json(name = "slk")
            val slk: String = "",
            @Json(name = "spa")
            val spa: String = "",
            @Json(name = "swe")
            val swe: String = "",
            @Json(name = "urd")
            val urd: String = "",
            @Json(name = "zho")
            val zho: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Flag(
            @Json(name = "small")
            val small: String = "",
            @Json(name = "medium")
            val medium: String = "",
            @Json(name = "large")
            val large: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class RegionalBloc(
            @Json(name = "acronym")
            val acronym: String = "",
            @Json(name = "name")
            val name: String = "",
            @Json(name = "otherNames")
            val otherNames: List<String> = listOf(),
            @Json(name = "otherAcronyms")
            val otherAcronyms: List<String> = listOf()
        )
    }
}
