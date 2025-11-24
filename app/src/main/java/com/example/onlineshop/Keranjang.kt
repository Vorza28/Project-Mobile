class Keranjang : Fragment() {

    private lateinit var binding: FragmentKeranjangBinding
    private lateinit var adapterKeranjang: AdapterKeranjang
    private val listProduk = ArrayList<ModelKeranjang>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKeranjangBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // dummy data
        listProduk.add(ModelKeranjang(R.drawable.sample1, "Brand", "Nama produk", "Rp.10.000"))
        listProduk.add(ModelKeranjang(R.drawable.sample2, "Brand", "Nama produk", "Rp.10.000"))
        listProduk.add(ModelKeranjang(R.drawable.sample3, "Brand", "Nama produk", "Rp.10.000"))

        adapterKeranjang = AdapterKeranjang(listProduk)
        binding.rvKeranjang.layoutManager = LinearLayoutManager(requireContext())
        binding.rvKeranjang.adapter = adapterKeranjang

        binding.btnBayar.setOnClickListener {
            Toast.makeText(requireContext(), "Menuju Pembayaran", Toast.LENGTH_SHORT).show()
        }
    }
}
